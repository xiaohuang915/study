package com.huang.study.test.entity;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/6/5 10:41
 */
public class SignUtil {

    /**
     * 签名
     *
     * @param in
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] sign(InputStream in, PrivateKey privateKey) throws Exception {
        String transformAlgorithm = "http://www.w3.org/2000/09/xmldsig#enveloped-signature";
        String digestAlgorithm = "http://www.w3.org/2001/04/xmlenc#sha256";
        String canonicalizationAlgorithm = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments";
        String signAlgorithm = "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().parse(in);
        XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");
        Transform envelopedTransform = factory.newTransform(transformAlgorithm, (XMLStructure) null);
        DigestMethod digestMethod = factory.newDigestMethod(digestAlgorithm, null);
        CanonicalizationMethod canonicalizationMethod = factory.newCanonicalizationMethod(canonicalizationAlgorithm, (XMLStructure) null);
        SignatureMethod signatureMethod = factory.newSignatureMethod(signAlgorithm, null);
        Reference ref = factory.newReference("", digestMethod, Collections.singletonList(envelopedTransform), null, null);
        SignedInfo si = factory.newSignedInfo(canonicalizationMethod, signatureMethod, Collections.singletonList(ref));
        XMLSignature signature = factory.newXMLSignature(si, null);
        DOMSignContext domSignContext = new DOMSignContext(privateKey, doc.getDocumentElement());
        signature.sign(domSignContext);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty("omit-xml-declaration", "no");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        StreamResult streamResult = new StreamResult(outputStream);
        transformer.transform(new DOMSource(doc), streamResult);
        return outputStream.toByteArray();
    }

    /**
     * 验签
     *
     * @param bytes
     * @param publicKey
     * @throws Exception
     */
    public static void verifySign(byte[] bytes, PublicKey publicKey) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document document = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(bytes));
        Node signatureNode = null;
        NodeList childNodes = document.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Signature");
        if (childNodes.getLength() == 1) {
            signatureNode = childNodes.item(0);
        } else {
            if (childNodes.getLength() == 0) {
                throw new Exception("no signature node named Signature in dom");
            }
            throw new Exception("more than one signature node named Signature in dom");
        }
        DOMValidateContext valContext = new DOMValidateContext(publicKey, signatureNode);
        XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");
        XMLSignature signature = factory.unmarshalXMLSignature(valContext);
        if (!signature.validate(valContext)) {
            System.out.println("verify result: " + signature.validate(valContext));
            throw new Exception("xml signature verify failed");
        } else {
            System.out.println("verify result: " + signature.validate(valContext));
        }
    }

    public static PrivateKey loadPrivateKey(InputStream in, String pkcs) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            if ("PKCS1".equals(pkcs)) {
                return null;
            } else if ("PKCS8".equals(pkcs)) {
                return loadPrivateKeyWithPcks8(sb.toString());
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException e) {
            throw new Exception("私钥输入流为空");
        } catch (Exception e) {
            throw e;
        }
    }



    public static PrivateKey loadPrivateKeyWithPcks8(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = Base64.decode(privateKeyStr);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        } catch (Exception e) {
            throw e;
        }
    }

    public static PublicKey loadPublicKey(InputStream in) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            return loadPublicKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        } catch (Exception e) {
            throw e;
        }
    }

    public static PublicKey loadPublicKey(String publicKeyKeyStr) throws Exception {
        try {
            byte[] buffer = Base64.decode(publicKeyKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (Exception e) {
            throw e;
        }

    }
}
