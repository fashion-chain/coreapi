package org.fok.core.api;

import java.math.BigInteger;
import java.util.List;

import org.fok.core.model.Account.AccountCryptoToken;
import org.fok.core.model.Account.AccountInfo;
import org.fok.core.model.Account.CryptoTokenValue;
import org.fok.core.model.Account.TokenValue;

import com.google.protobuf.ByteString;

/**
 * @author king.camulos@gmail.com
 *
 */
public interface IAccountHandler {
	AccountInfo.Builder createAccount(byte[] address);

	AccountInfo.Builder createUnionAccount(ByteString address, ByteString max, ByteString acceptMax, int acceptLimit,
			List<ByteString> addresses);

	AccountInfo.Builder createContract(byte[] address, byte[] contract);

	int increaseNonce(AccountInfo.Builder account);

	BigInteger getBalance(AccountInfo.Builder account);

	BigInteger subBalance(AccountInfo.Builder oAccount, BigInteger amount);

	BigInteger addBalance(AccountInfo.Builder oAccount, BigInteger amount);

	byte[] lockBalanceAddress();

	BigInteger getTokenBalance(AccountInfo.Builder oAccount, byte[] token);

	BigInteger subTokenBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	BigInteger addTokenBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	BigInteger getTokenFreezeBalance(AccountInfo.Builder oAccount, byte[] token);

	BigInteger subTokenFreezeBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	BigInteger addTokenFreezeBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	BigInteger getTokenLockedBalance(AccountInfo.Builder oAccount, byte[] token);

	BigInteger subTokenLockedBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	BigInteger addTokenLockedBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	byte[] tokenValueAddress();

	TokenValue getToken(AccountInfo.Builder oAccount, byte[] token);

	void putToken(AccountInfo.Builder oAccount, byte[] token, TokenValue tokenValue);

	AccountCryptoToken getCryptoTokenBalance(AccountInfo.Builder oAccount, byte[] symbol, byte[] hash);

	void addCryptoTokenBalance(AccountInfo.Builder oAccount, byte[] symbol, AccountCryptoToken cryptoTokenHash);

	void removeCryptoTokenBalance(AccountInfo.Builder oAccount, byte[] symbol, AccountCryptoToken cryptoTokenHash);

	byte[] cryptoTokenValueAddress();

	CryptoTokenValue getCryptoToken(AccountInfo.Builder oAccount, byte[] symbol);

	void putCryptoToken(AccountInfo.Builder oAccount, byte[] symbol, CryptoTokenValue cryptoTokenValue);

	byte[] getAccountStorage(AccountInfo.Builder oAccount, byte[] key);

	void putAccountStorage(AccountInfo.Builder oAccount, byte[] key, byte[] value);
}
