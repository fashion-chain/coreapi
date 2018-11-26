package org.fok.core.api;

import com.google.protobuf.ByteString;
import org.fok.core.model.Account.AccountInfo;
import org.fok.core.model.Block.BlockInfo;
import org.fok.core.model.Transaction.TransactionInfo;
import org.fok.tools.bytes.BytesHashMap;

import java.util.Map;

/**
 * @author king.camulos@gmail.com
 *
 */
public interface ITransactionHandler {
	void setTransactionDone(TransactionInfo transaction, BlockInfo block, ByteString result);
	void setTransactionError(TransactionInfo transaction, BlockInfo block, ByteString result);
}
