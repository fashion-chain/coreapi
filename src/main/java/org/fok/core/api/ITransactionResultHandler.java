package org.fok.core.api;

import org.fok.core.model.Block.BlockInfo;
import org.fok.core.model.Transaction.TransactionInfo;

import com.google.protobuf.ByteString;

public interface ITransactionResultHandler {
	void setTransactionDone(TransactionInfo transaction, BlockInfo block, ByteString result) throws Exception;

	void setTransactionError(TransactionInfo transaction, BlockInfo block, ByteString result) throws Exception;
}
