package ar.com.betex.blockchain.sc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class IBetexLaurasiaGondwana extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_OPENMARKETWITH2RUNNERS = "openMarketWith2Runners";

    public static final String FUNC_OPENMARKETWITH3RUNNERS = "openMarketWith3Runners";

    public static final String FUNC_SUSPENDMARKET = "suspendMarket";

    public static final String FUNC_CLOSEMARKET = "closeMarket";

    public static final String FUNC_RESOLVEMARKET = "resolveMarket";

    public static final String FUNC_ISWINNER = "isWinner";

    public static final String FUNC_MARKETRUNNEREXISTS = "marketRunnerExists";

    public static final String FUNC_CLOSEEVENT = "closeEvent";

    public static final String FUNC_SUSPENDEVENT = "suspendEvent";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected IBetexLaurasiaGondwana(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IBetexLaurasiaGondwana(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IBetexLaurasiaGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IBetexLaurasiaGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> openMarketWith2Runners(BigInteger _eventId, BigInteger _marketId, byte[] _runnerHash01, byte[] _runnerHash02) {
        final Function function = new Function(
                FUNC_OPENMARKETWITH2RUNNERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_eventId), 
                new org.web3j.abi.datatypes.generated.Uint256(_marketId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_runnerHash01), 
                new org.web3j.abi.datatypes.generated.Bytes32(_runnerHash02)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> openMarketWith3Runners(BigInteger _eventId, BigInteger _marketId, byte[] _runnerHash01, byte[] _runnerHash02, byte[] _runnerHash03) {
        final Function function = new Function(
                FUNC_OPENMARKETWITH3RUNNERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_eventId), 
                new org.web3j.abi.datatypes.generated.Uint256(_marketId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_runnerHash01), 
                new org.web3j.abi.datatypes.generated.Bytes32(_runnerHash02), 
                new org.web3j.abi.datatypes.generated.Bytes32(_runnerHash03)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> suspendMarket(BigInteger _marketId) {
        final Function function = new Function(
                FUNC_SUSPENDMARKET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> closeMarket(BigInteger _marketId) {
        final Function function = new Function(
                FUNC_CLOSEMARKET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> resolveMarket(BigInteger _marketId, byte[] _winnerMarketRunnerHash) {
        final Function function = new Function(
                FUNC_RESOLVEMARKET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_winnerMarketRunnerHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isWinner(byte[] _marketRunnerHash) {
        final Function function = new Function(FUNC_ISWINNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> marketRunnerExists(byte[] _marketRunnerHash) {
        final Function function = new Function(FUNC_MARKETRUNNEREXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> closeEvent(BigInteger _eventId) {
        final Function function = new Function(
                FUNC_CLOSEEVENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_eventId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> suspendEvent(BigInteger _eventId) {
        final Function function = new Function(
                FUNC_SUSPENDEVENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_eventId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IBetexLaurasiaGondwana load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBetexLaurasiaGondwana(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IBetexLaurasiaGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBetexLaurasiaGondwana(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IBetexLaurasiaGondwana load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IBetexLaurasiaGondwana(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IBetexLaurasiaGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IBetexLaurasiaGondwana(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IBetexLaurasiaGondwana> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBetexLaurasiaGondwana.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBetexLaurasiaGondwana> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBetexLaurasiaGondwana.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IBetexLaurasiaGondwana> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBetexLaurasiaGondwana.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBetexLaurasiaGondwana> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBetexLaurasiaGondwana.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
