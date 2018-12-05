package org.fok.core.api;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.fok.core.cryptoapi.ICryptoHandler;
import org.fok.core.model.Account.AccountInfo;

import com.google.protobuf.ByteString;

public interface IAccountEVMHandler {
	public ICryptoHandler getCrypto();
	public AccountInfo GetAccount(ByteString addr);
	public boolean isExist(ByteString addr);
	public BigInteger addBalance(ByteString addr, BigInteger balance);
	public BigInteger getBalance(ByteString addr);
	public void saveStorage(ByteString address, byte[] key, byte[] value);
	public Map<String, byte[]> getStorage(ByteString address, List<byte[]> keys);
	public byte[] getStorage(ByteString address, byte[] key) ;
}
