package org.fok.core.api;

import org.fok.core.model.Account.AccountInfo;
import org.fok.core.model.Block.BlockInfo;
import org.fok.core.model.Transaction.TransactionInfo;
import org.fok.tools.bytes.BytesHashMap;

import com.google.protobuf.ByteString;

public interface ITransactionExecutorHandler {
    boolean needSignature();
    /**
     * 交易签名校验
     * @param transactionInfo
     * @param accounts
     * @throws Exception
     */
    void onVerifySignature(TransactionInfo transactionInfo, BytesHashMap<AccountInfo.Builder> accounts) throws Exception;

    /**
     * 交易执行前的数据校验
     * @param transactionInfo
     * @param accounts
     * @throws Exception
     */
    void onPrepareExecute(TransactionInfo transactionInfo, BytesHashMap<AccountInfo.Builder> accounts) throws Exception;

    /**
     * 交易执行
     * @param transactionInfo
     * @param accounts
     * @return
     * @throws Exception
     */
    ByteString onExecute(TransactionInfo transactionInfo, BytesHashMap<AccountInfo.Builder> accounts) throws Exception;

    /**
     * 交易执行成功后
     * @param transactionInfo
     * @param be
     * @param result
     * @throws Exception
     */
    void onExecuteDone(TransactionInfo transactionInfo, BlockInfo be, ByteString result) throws Exception;

    /**
     * 交易执行失败后
     * @param transactionInfo
     * @param be
     * @param result
     * @throws Exception
     */
    void onExecuteError(TransactionInfo transactionInfo, BlockInfo be, ByteString result) throws Exception;

}
