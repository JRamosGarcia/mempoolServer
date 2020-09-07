package com.mempool.server.components.clients;

import com.mempool.server.bitcoind.entities.results.GetMemPoolInfo;
import com.mempool.server.bitcoind.entities.results.GetRawMemPoolNonVerbose;

public interface BitcoindClient {

	GetRawMemPoolNonVerbose getRawMemPoolNonVerbose();

	GetMemPoolInfo getMemPoolInfo();

}