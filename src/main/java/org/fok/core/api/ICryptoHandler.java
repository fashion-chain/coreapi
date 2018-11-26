package org.fok.core.api;

import org.fok.core.api.model.Crypto.AccountKeyPair;

public interface ICryptoHandler {
	String bytesToHexStr(byte[] bytes);

	byte[] hexStrToBytes(String hexStr);

	byte[] sha3(byte[] bytes);

	byte[] sha256(byte[] bytes);

	AccountKeyPair genAccountKey();

	AccountKeyPair genAccountKey(String text);

	byte[] sign(byte[] privateKey, byte[] content);

	byte[] signatureToAddress(byte[] content, byte[] signature);

	byte[] signatureToKey(byte[] content, byte[] signature);

	boolean verify(byte[] publicKey, byte[] content, byte[] signature);

	AccountKeyPair restoreKeyStore(String keyStoreStr, String pwd);

	String genKeyStoreJson(AccountKeyPair accountKey, String pwd);
}
