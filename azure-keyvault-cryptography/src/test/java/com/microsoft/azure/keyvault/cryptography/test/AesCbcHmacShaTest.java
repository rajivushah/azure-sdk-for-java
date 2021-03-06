package com.microsoft.azure.keyvault.cryptography.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.microsoft.azure.keyvault.cryptography.IAuthenticatedCryptoTransform;
import com.microsoft.azure.keyvault.cryptography.ICryptoTransform;
import com.microsoft.azure.keyvault.cryptography.algorithms.Aes128CbcHmacSha256;

public class AesCbcHmacShaTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAes128CbcHmacSha256() {
        // Arrange: These values are taken from Appendix B of the JWE
        // specification at
        // https://tools.ietf.org/html/draft-ietf-jose-json-web-encryption-40#appendix-B
        byte[] CEK = { 4, (byte) 211, 31, (byte) 197, 84, (byte) 157, (byte) 252, (byte) 254, 11, 100, (byte) 157, (byte) 250, 63, (byte) 170, 106, (byte) 206, 107, 124, (byte) 212, 45, 111, 107, 9, (byte) 219, (byte) 200, (byte) 177, 0, (byte) 240, (byte) 143, (byte) 156, 44, (byte) 207 };
        byte[] PLAIN = { 76, 105, 118, 101, 32, 108, 111, 110, 103, 32, 97, 110, 100, 32, 112, 114, 111, 115, 112, 101, 114, 46 };
        byte[] IV = { 3, 22, 60, 12, 43, 67, 104, 105, 108, 108, 105, 99, 111, 116, 104, 101 };
        byte[] AUTH = { 101, 121, 74, 104, 98, 71, 99, 105, 79, 105, 74, 66, 77, 84, 73, 52, 83, 49, 99, 105, 76, 67, 74, 108, 98, 109, 77, 105, 79, 105, 74, 66, 77, 84, 73, 52, 81, 48, 74, 68, 76, 85, 104, 84, 77, 106, 85, 50, 73, 110, 48 };
        byte[] ED = { 40, 57, 83, (byte) 181, 119, 33, (byte) 133, (byte) 148, (byte) 198, (byte) 185, (byte) 243, 24, (byte) 152, (byte) 230, 6, 75, (byte) 129, (byte) 223, 127, 19, (byte) 210, 82, (byte) 183, (byte) 230, (byte) 168, 33, (byte) 215, 104, (byte) 143, 112, 56, 102 };
        byte[] TAG = { 83, 73, (byte) 191, 98, 104, (byte) 205, (byte) 211, (byte) 128, (byte) 201, (byte) 189, (byte) 199, (byte) 133, 32, 38, (byte) 194, 85 };

        Aes128CbcHmacSha256 algo = new Aes128CbcHmacSha256();

        IAuthenticatedCryptoTransform transform = null;

        byte[] encrypted = null;
        byte[] tag = null;

        try {
            transform = (IAuthenticatedCryptoTransform) algo.CreateEncryptor(CEK, IV, AUTH);
        } catch (InvalidKeyException e1) {
            fail("InvalidKeyException");
        } catch (NoSuchAlgorithmException e1) {
            fail("NoSuchAlgorithmException");
        } catch (NoSuchPaddingException e1) {
            fail("NoSuchPaddingException");
        } catch (InvalidAlgorithmParameterException e1) {
            fail("InvalidAlgorithmParameterException");
        }

        try {
            encrypted = transform.doFinal(PLAIN);
            tag = transform.getTag();

            assertArrayEquals(ED, encrypted);
            assertArrayEquals(TAG, tag);

        } catch (IllegalBlockSizeException e) {
            fail("IllegalBlockSizeException");
        } catch (BadPaddingException e) {
            fail("BadPaddingException");
        } catch (InvalidKeyException e) {
            fail("InvalidKeyException");
        } catch (NoSuchAlgorithmException e) {
            fail("NoSuchAlgorithmException");
        }

        ICryptoTransform decryptor = null;
        try {
            decryptor = algo.CreateDecryptor(CEK, IV, AUTH);
        } catch (InvalidKeyException e1) {
            fail("InvalidKeyException");
        } catch (NoSuchAlgorithmException e1) {
            fail("NoSuchAlgorithmException");
        } catch (NoSuchPaddingException e1) {
            fail("NoSuchPaddingException");
        } catch (InvalidAlgorithmParameterException e1) {
            fail("InvalidAlgorithmParameterException");
        }

        byte[] decrypted = null;

        try {
            decrypted = decryptor.doFinal(encrypted);
        } catch (IllegalBlockSizeException e) {
            fail("IllegalBlockSizeException");
        } catch (BadPaddingException e) {
            fail("BadPaddingException");
        } catch (InvalidKeyException e) {
            fail("InvalidKeyException");
        } catch (NoSuchAlgorithmException e) {
            fail("NoSuchAlgorithmException");
        }

        // Assert
        assertArrayEquals(PLAIN, decrypted);
    }

}
