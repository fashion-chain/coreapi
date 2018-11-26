package org.fok.core.api;

import java.math.BigInteger;
import java.util.List;

import org.fok.core.model.Account.AccountCryptoToken;
import org.fok.core.model.Account.AccountInfo;
import org.fok.core.model.Account.CryptoTokenValue;
import org.fok.core.model.Account.TokenValue;

import com.google.protobuf.ByteString;

/**
 * @author
 *
 */
/**
 * @author liubo
 *
 */
public interface IAccountHandler {

	/**
	 * 返回系统内置的手续费收费账户地址
	 * 
	 * @return
	 */
	byte[] lockBalanceAddress();

	/**
	 * 返回系统内置的token账户地址。该账户保存着系统内已创建的全部的token的信息。
	 * 
	 * @return
	 */
	byte[] tokenValueAddress();

	/**
	 * 返回系统内容的Crypto-token账户地址。该账户保存着系统内一创建的全部Crypto-token的信息。
	 * 
	 * @return
	 */
	byte[] cryptoTokenValueAddress();

	/**
	 * 根据地址创建账户
	 * <p>
	 * 此方法不会持久化任何对象
	 * 
	 * @param address
	 *            账户地址
	 * @return
	 */
	AccountInfo.Builder createAccount(byte[] address);

	/**
	 * 创建联合账户
	 * <p>
	 * 此方法不会持久化任何对象
	 * 
	 * @param address
	 *            账户地址
	 * @param max
	 *            日最大转账金额
	 * @param acceptMax
	 *            单笔最大转账金额
	 * @param acceptLimit
	 *            当超过 <code> acceptMax </code> 的金额时，需要的确认次数
	 * @param addresses
	 *            关联子账户
	 * @return
	 */
	AccountInfo.Builder createUnionAccount(ByteString address, ByteString max, ByteString acceptMax, int acceptLimit,
			List<ByteString> addresses);

	/**
	 * 创建合约账户
	 * <p>
	 * 此方法不会持久化任何对象
	 * 
	 * @param address
	 *            合约地址
	 * @param code
	 *            合约内容
	 * @param codeHash
	 * @param data
	 * @return
	 */
	AccountInfo.Builder createContract(byte[] address, byte[] code, byte[] codeHash, byte[] data);

	/**
	 * 获取账户的nonce
	 * 
	 * @param account
	 * @return
	 */
	int getNonce(AccountInfo.Builder account);

	/**
	 * 增加账户的nonce。每次调用nonce + 1
	 * <p>
	 * 此方法不会持久化任何对象
	 * 
	 * @param account
	 * @return
	 */
	int increaseNonce(AccountInfo.Builder account);

	/**
	 * 获取账户的基本余额
	 * <p>
	 * 基本余额始终大于等于0
	 * 
	 * @param account
	 * @return
	 */
	BigInteger getBalance(AccountInfo.Builder account);

	/**
	 * 减少账户余额
	 * <p>
	 * 此方法不会持久化任何对象
	 * 
	 * @param oAccount
	 * @param amount
	 * @return
	 */
	BigInteger subBalance(AccountInfo.Builder oAccount, BigInteger amount);

	/**
	 * 增加账户余额
	 * <p>
	 * 此方法不会持久化任何对象
	 * 
	 * @param oAccount
	 * @param amount
	 * @return
	 */
	BigInteger addBalance(AccountInfo.Builder oAccount, BigInteger amount);

	/**
	 * 获取账户的token余额。如果账户内不包含<code>token</code>,则返回-1.
	 * <p>
	 * token的余额应始终大于等于0
	 * 
	 * @param oAccount
	 * @param token
	 * @return
	 */
	BigInteger getTokenBalance(AccountInfo.Builder oAccount, byte[] token);

	/**
	 * 减少账户的token余额.如果账户内不包含<code>token</code>,则返回-1.
	 * <p>
	 * token的余额应始终大于等于0
	 * 
	 * @param oAccount
	 * @param token
	 * @param amount
	 * @return
	 */
	BigInteger subTokenBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	/**
	 * 增加账户的token余额.
	 * 
	 * @param oAccount
	 * @param token
	 * @param amount
	 * @return
	 */
	BigInteger addTokenBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	/**
	 * 获取账户的token冻结余额。如果该账户没有<code>token</code>，则返回-1。如果该账户的<code>token</code>没有冻结余额，则返回0。
	 * 
	 * @param oAccount
	 * @param token
	 * @return
	 */
	BigInteger getTokenFreezeBalance(AccountInfo.Builder oAccount, byte[] token);

	/**
	 * 减少账户的token冻结余额。如果该账户没有<code>token</code>，则返回-1。如果该账户的<code>token</code>没有锁定余额，则返回0。
	 * <p>
	 * token的冻结余额应始终大于等于0
	 * 
	 * @param oAccount
	 * @param token
	 * @param amount
	 * @return
	 */
	BigInteger subTokenFreezeBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	/**
	 * 增加账户的token冻结余额。
	 * 
	 * @param oAccount
	 * @param token
	 * @param amount
	 * @return
	 */
	BigInteger addTokenFreezeBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	/**
	 * 获取账户的token锁定余额。如果账户内不包含<code>token</code>,则返回-1.
	 * <p>
	 * token的锁定余额应始终大于等于0
	 * 
	 * @param oAccount
	 * @param token
	 * @return
	 */
	BigInteger getTokenLockedBalance(AccountInfo.Builder oAccount, byte[] token);

	/**
	 * 减少token的锁定余额。如果账户内不包含<code>token</code>,则返回-1.
	 * <p>
	 * token的锁定余额应始终大于等于0
	 * 
	 * @param oAccount
	 * @param token
	 * @param amount
	 * @return
	 */
	BigInteger subTokenLockedBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	/**
	 * 增加token的锁定余额。
	 * 
	 * @param oAccount
	 * @param token
	 * @param amount
	 * @return
	 */
	BigInteger addTokenLockedBalance(AccountInfo.Builder oAccount, byte[] token, BigInteger amount);

	/**
	 * 从token账户中，获取<code>token</code>的发行信息
	 * 
	 * @param oAccount
	 * @param token
	 * @return
	 */
	TokenValue getToken(AccountInfo.Builder oAccount, byte[] token);

	/**
	 * 更新token的发行信息
	 * 
	 * @param oAccount
	 * @param token
	 * @param tokenValue
	 */
	void putToken(AccountInfo.Builder oAccount, byte[] token, TokenValue tokenValue);

	/**
	 * 获取账户的crypto-token。如果该账户不存在满足<code>symbol</code>和<code>hash</code>的crypto-token，则返回null。
	 * 
	 * @param oAccount
	 * @param symbol
	 * @param hash
	 * @return
	 */
	AccountCryptoToken getCryptoTokenBalance(AccountInfo.Builder oAccount, byte[] symbol, byte[] hash);

	/**
	 * 给账户添加crypto-token。
	 * <p>
	 * 该方法不校验是否已经持有了crypto-token，如果已经持有了，则会更新。否则添加一个。
	 * 
	 * @param oAccount
	 * @param symbol
	 * @param cryptoTokenHash
	 */
	void addCryptoTokenBalance(AccountInfo.Builder oAccount, byte[] symbol, AccountCryptoToken cryptoTokenHash);

	/**
	 * 从账户中移除crypto-token。
	 * 
	 * @param oAccount
	 * @param symbol
	 * @param cryptoTokenHash
	 */
	void removeCryptoTokenBalance(AccountInfo.Builder oAccount, byte[] symbol, byte[] hash);

	/**
	 * 获取系统中已经存在的crypto-token的发行信息。如果<code>symbol</code>不存在，则返回null。
	 * 
	 * @param oAccount
	 * @param symbol
	 * @return
	 */
	CryptoTokenValue getCryptoToken(AccountInfo.Builder oAccount, byte[] symbol);

	/**
	 * 创建或更新crypto-token的发行信息。
	 * 
	 * @param oAccount
	 * @param symbol
	 * @param cryptoTokenValue
	 */
	void putCryptoToken(AccountInfo.Builder oAccount, byte[] symbol, CryptoTokenValue cryptoTokenValue);

	/**
	 * 获取账户的storage。若不存在<code>key</code>，则返回null。
	 * <p>
	 * storage存储结构为[{key:value}]
	 * 
	 * @param oAccount
	 * @param key
	 * @return
	 */
	byte[] getAccountStorage(AccountInfo.Builder oAccount, byte[] key);

	/**
	 * 创建或更新账户的storage。
	 * 
	 * @param oAccount
	 * @param key
	 * @param value
	 */
	void putAccountStorage(AccountInfo.Builder oAccount, byte[] key, byte[] value);
}
