package ar.com.betex.blockchain.sc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
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
public class IBetexMobileGondwana extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_ISPAUSED = "isPaused";

    public static final String FUNC_SAVEUSERSETTINGS = "saveUserSettings";

    public static final String FUNC_GETUSERSETTINGS = "getUserSettings";

    public static final String FUNC_ISSELFEXCLUDED = "isSelfExcluded";

    public static final String FUNC_PLACEMARKETBETBTX = "placeMarketBetBtx";

    public static final String FUNC_PLACEMARKETBETWEI = "placeMarketBetWei";

    public static final String FUNC_CANCELMARKETBET = "cancelMarketBet";

    public static final String FUNC_CHARGEMARKETBET = "chargeMarketBet";

    public static final String FUNC_GETMAXODDS = "getMaxOdds";

    public static final String FUNC_CREATEP2PBETWEI = "createP2PBetWei";

    public static final String FUNC_CREATEP2PBETBTX = "createP2PBetBtx";

    public static final String FUNC_ACCEPTP2PBETBTX = "acceptP2PBetBtx";

    public static final String FUNC_ACCEPTP2PBETWEI = "acceptP2PBetWei";

    public static final String FUNC_CANCELP2PBET = "cancelP2PBet";

    public static final String FUNC_REFUSEP2PBET = "refuseP2PBet";

    public static final String FUNC_CHARGEP2PBET = "chargeP2PBet";

    public static final String FUNC_ISWINNER = "isWinner";

    public static final String FUNC_GETDEFAULTMAXAMOUNTWEIPERDAY = "getDefaultMaxAmountWeiPerDay";

    public static final String FUNC_GETDEFAULTMAXAMOUNTBTXPERDAY = "getDefaultMaxAmountBtxPerDay";

    public static final String FUNC_GETDEFAULTMAXBETSPERDAY = "getDefaultMaxBetsPerDay";

    public static final String FUNC_GETMINSTAKEBTX = "getMinStakeBtx";

    public static final String FUNC_GETMAXSTAKEBTX = "getMaxStakeBtx";

    public static final String FUNC_GETMINSTAKEWEI = "getMinStakeWei";

    public static final String FUNC_GETMAXSTAKEWEI = "getMaxStakeWei";

    public static final String FUNC_GETCOMISSIONWINNERBETWEI = "getComissionWinnerBetWei";

    public static final String FUNC_GETCOMISSIONCANCELBETWEI = "getComissionCancelBetWei";

    public static final String FUNC_GETCOMISSIONWINNERBETBTX = "getComissionWinnerBetBtx";

    public static final String FUNC_GETCOMISSIONCANCELBETBTX = "getComissionCancelBetBtx";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected IBetexMobileGondwana(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IBetexMobileGondwana(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IBetexMobileGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IBetexMobileGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> isPaused() {
        final Function function = new Function(FUNC_ISPAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> saveUserSettings(BigInteger _amountWeiPerDay, BigInteger _amountBtxPerDay, BigInteger _maxBetsPerDay) {
        final Function function = new Function(
                FUNC_SAVEUSERSETTINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amountWeiPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_amountBtxPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxBetsPerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>> getUserSettings() {
        final Function function = new Function(FUNC_GETUSERSETTINGS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> isSelfExcluded() {
        final Function function = new Function(FUNC_ISSELFEXCLUDED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> placeMarketBetBtx(byte[] _marketRunnerHash, BigInteger _odd, BigInteger _stake, Boolean _isBack) {
        final Function function = new Function(
                FUNC_PLACEMARKETBETBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash), 
                new org.web3j.abi.datatypes.generated.Uint256(_odd), 
                new org.web3j.abi.datatypes.generated.Uint256(_stake), 
                new org.web3j.abi.datatypes.Bool(_isBack)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> placeMarketBetWei(byte[] _marketRunnerHash, BigInteger _odd, BigInteger _stake, Boolean _isBack, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PLACEMARKETBETWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash), 
                new org.web3j.abi.datatypes.generated.Uint256(_odd), 
                new org.web3j.abi.datatypes.generated.Uint256(_stake), 
                new org.web3j.abi.datatypes.Bool(_isBack)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> cancelMarketBet(BigInteger _betId) {
        final Function function = new Function(
                FUNC_CANCELMARKETBET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> chargeMarketBet(BigInteger _betId) {
        final Function function = new Function(
                FUNC_CHARGEMARKETBET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> getMaxOdds(byte[] _marketRunnerHash) {
        final Function function = new Function(FUNC_GETMAXODDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> createP2PBetWei(byte[] _marketRunnerHash, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CREATEP2PBETWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> createP2PBetBtx(byte[] _marketRunnerHash, BigInteger _amountBtx) {
        final Function function = new Function(
                FUNC_CREATEP2PBETBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_marketRunnerHash), 
                new org.web3j.abi.datatypes.generated.Uint256(_amountBtx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> acceptP2PBetBtx(BigInteger _betId, BigInteger _amount) {
        final Function function = new Function(
                FUNC_ACCEPTP2PBETBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> acceptP2PBetWei(BigInteger _betId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ACCEPTP2PBETWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> cancelP2PBet(BigInteger _betId) {
        final Function function = new Function(
                FUNC_CANCELP2PBET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> refuseP2PBet(BigInteger _betId) {
        final Function function = new Function(
                FUNC_REFUSEP2PBET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> chargeP2PBet(BigInteger _betId) {
        final Function function = new Function(
                FUNC_CHARGEP2PBET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isWinner(BigInteger _betId) {
        final Function function = new Function(FUNC_ISWINNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> getDefaultMaxAmountWeiPerDay() {
        final Function function = new Function(
                FUNC_GETDEFAULTMAXAMOUNTWEIPERDAY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDefaultMaxAmountBtxPerDay() {
        final Function function = new Function(
                FUNC_GETDEFAULTMAXAMOUNTBTXPERDAY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDefaultMaxBetsPerDay() {
        final Function function = new Function(
                FUNC_GETDEFAULTMAXBETSPERDAY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getMinStakeBtx() {
        final Function function = new Function(FUNC_GETMINSTAKEBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getMaxStakeBtx() {
        final Function function = new Function(FUNC_GETMAXSTAKEBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getMinStakeWei() {
        final Function function = new Function(FUNC_GETMINSTAKEWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getMaxStakeWei() {
        final Function function = new Function(FUNC_GETMAXSTAKEWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getComissionWinnerBetWei() {
        final Function function = new Function(FUNC_GETCOMISSIONWINNERBETWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getComissionCancelBetWei() {
        final Function function = new Function(FUNC_GETCOMISSIONCANCELBETWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getComissionWinnerBetBtx() {
        final Function function = new Function(FUNC_GETCOMISSIONWINNERBETBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getComissionCancelBetBtx() {
        final Function function = new Function(FUNC_GETCOMISSIONCANCELBETBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static IBetexMobileGondwana load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBetexMobileGondwana(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IBetexMobileGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IBetexMobileGondwana(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IBetexMobileGondwana load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IBetexMobileGondwana(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IBetexMobileGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IBetexMobileGondwana(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IBetexMobileGondwana> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBetexMobileGondwana.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBetexMobileGondwana> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBetexMobileGondwana.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IBetexMobileGondwana> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IBetexMobileGondwana.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IBetexMobileGondwana> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IBetexMobileGondwana.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
