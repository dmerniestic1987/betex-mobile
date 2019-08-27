package ar.com.betex.blockchain.sc;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
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
public class BetexLaurasiaGondwana extends Contract {
    private static final String BINARY = "0x60806040819052600080546001600160a01b03191633178082556001600160a01b0316917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a3611251806100576000396000f3fe608060405234801561001057600080fd5b50600436106100fc5760003560e01c806301bf6648146101015780632ee07c001461012957806336a36f7c14610146578063433fac851461016a578063556cca6e14610172578063715018a61461017a57806377c75d101461018257806389fe735d146101b35780638da5cb5b146101d05780638f32d59b146101d857806390127367146101e0578063931b5466146101fd578063ac9c92151461021a578063ae4180951461024f578063c559c9611461026c578063d82aff111461029b578063f09a4016146102c1578063f2fde38b146102ef578063fc88d5f214610315578063fe1439b414610338575b600080fd5b6101276004803603602081101561011757600080fd5b50356001600160a01b031661035e565b005b6101276004803603602081101561013f57600080fd5b503561045c565b61014e610524565b604080516001600160a01b039092168252519081900360200190f35b61014e610538565b61014e610591565b6101276105ea565b61019f6004803603602081101561019857600080fd5b5035610669565b604080519115158252519081900360200190f35b61019f600480360360208110156101c957600080fd5b50356106f6565b61014e610751565b61019f610760565b610127600480360360208110156101f657600080fd5b5035610771565b6101276004803603602081101561021357600080fd5b503561081e565b610127600480360360a081101561023057600080fd5b50803590602081013590604081013590606081013590608001356108cb565b6101276004803603602081101561026557600080fd5b5035610a56565b6101276004803603608081101561028257600080fd5b5080359060208101359060408101359060600135610b03565b610127600480360360208110156102b157600080fd5b50356001600160a01b0316610c71565b610127600480360360408110156102d757600080fd5b506001600160a01b0381358116916020013516610d80565b6101276004803603602081101561030557600080fd5b50356001600160a01b0316610e4b565b6101276004803603604081101561032b57600080fd5b5080359060200135610e9e565b6101276004803603602081101561034e57600080fd5b50356001600160a01b0316610f62565b610366610760565b6103a5576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b6001600160a01b03811660009081526003602052604090205460ff16610404576040805162461bcd60e51b815260206004820152600f60248201526e139bdd081dda5d1a195b1a5cdd1959608a1b604482015290519081900360640190fd5b6001600160a01b038116600081815260036020908152604091829020805460ff19169055815192835290517fffe6b8088a5bb820a86181b172a4fc5d5ec985ed70b88e0815e76e5480d55c819281900390910190a150565b3360009081526003602052604090205460ff166104ae576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b600460019054906101000a90046001600160a01b03166001600160a01b0316632ee07c00826040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b15801561050957600080fd5b505af115801561051d573d6000803e3d6000fd5b5050505050565b60045461010090046001600160a01b031681565b6000610542610760565b610581576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b506002546001600160a01b031690565b600061059b610760565b6105da576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b506001546001600160a01b031690565b6105f2610760565b610631576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b600080546040516001600160a01b03909116906000805160206111fd833981519152908390a3600080546001600160a01b0319169055565b6000600460019054906101000a90046001600160a01b03166001600160a01b03166377c75d10836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156106c457600080fd5b505afa1580156106d8573d6000803e3d6000fd5b505050506040513d60208110156106ee57600080fd5b505192915050565b6000600460019054906101000a90046001600160a01b03166001600160a01b031663dc0adcb1836040518263ffffffff1660e01b81526004018082815260200191505060206040518083038186803b1580156106c457600080fd5b6000546001600160a01b031690565b6000546001600160a01b0316331490565b3360009081526003602052604090205460ff166107c3576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b600460019054906101000a90046001600160a01b03166001600160a01b03166390127367826040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b15801561050957600080fd5b3360009081526003602052604090205460ff16610870576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b600460019054906101000a90046001600160a01b03166001600160a01b031663931b5466826040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b15801561050957600080fd5b3360009081526003602052604090205460ff1661091d576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b60408051600380825260808201909252606091602082018380388339019050509050838160008151811061094d57fe5b602002602001018181525050828160018151811061096757fe5b602002602001018181525050818160028151811061098157fe5b602002602001018181525050600460019054906101000a90046001600160a01b03166001600160a01b031663f3ba59118787846040518463ffffffff1660e01b81526004018084815260200183815260200180602001828103825283818151815260200191508051906020019060200280838360005b83811015610a0f5781810151838201526020016109f7565b50505050905001945050505050600060405180830381600087803b158015610a3657600080fd5b505af1158015610a4a573d6000803e3d6000fd5b50505050505050505050565b3360009081526003602052604090205460ff16610aa8576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b600460019054906101000a90046001600160a01b03166001600160a01b031663ae418095826040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b15801561050957600080fd5b3360009081526003602052604090205460ff16610b55576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b60408051600280825260608083018452926020830190803883390190505090508281600081518110610b8357fe5b6020026020010181815250508181600181518110610b9d57fe5b602002602001018181525050600460019054906101000a90046001600160a01b03166001600160a01b031663f3ba59118686846040518463ffffffff1660e01b81526004018084815260200183815260200180602001828103825283818151815260200191508051906020019060200280838360005b83811015610c2b578181015183820152602001610c13565b50505050905001945050505050600060405180830381600087803b158015610c5257600080fd5b505af1158015610c66573d6000803e3d6000fd5b505050505050505050565b610c79610760565b610cb8576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b610cc0610751565b6001600160a01b0316816001600160a01b03161415610d26576040805162461bcd60e51b815260206004820152601f60248201527f4f6e776572206d757374206e6f74206265204d61726b65744d616e6167657200604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b03838116919091179182905560408051929091168252517f4b7398b309ffc44650cb39cb11a622b3d7bea9f1a262dbcb62385598a4497bdf916020908290030190a150565b60045460ff1615610dd7576040805162461bcd60e51b815260206004820152601c60248201527b10dbdb9d1c9858dd08185b1c9958591e481a5b9a5d1a585b1a5e995960221b604482015290519081900360640190fd5b610ddf610760565b610e1e576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b60048054610100600160a81b0319166101006001600160a01b03851602179055610e4781611069565b5050565b610e53610760565b610e92576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b610e9b81611128565b50565b3360009081526003602052604090205460ff16610ef0576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b6004805460408051637e446af960e11b815292830185905260248301849052516101009091046001600160a01b03169163fc88d5f291604480830192600092919082900301818387803b158015610f4657600080fd5b505af1158015610f5a573d6000803e3d6000fd5b505050505050565b610f6a610760565b610fa9576040805162461bcd60e51b815260206004820181905260248201526000805160206111dd833981519152604482015290519081900360640190fd5b610fb1610751565b6001600160a01b0316816001600160a01b0316141561100f576040805162461bcd60e51b81526020600482015260156024820152744f6e776572206d757374206e6f742062652043544f60581b604482015290519081900360640190fd5b600280546001600160a01b0319166001600160a01b03838116919091179182905560408051929091168252517f3278084dec868221e78ff53abc452308624a817c9513c85687d76c12ecb87873916020908290030190a150565b6001600160a01b03811660009081526003602052604090205460ff16156110cd576040805162461bcd60e51b8152602060048201526013602482015272105b1c9958591e481dda5d1a195b1a5cdd1959606a1b604482015290519081900360640190fd5b6001600160a01b038116600081815260036020908152604091829020805460ff19166001179055815192835290517f832f053a3bb9766e023641dae65836917ded9bd6110f5854a0ba2b93ce32d5e09281900390910190a150565b6001600160a01b03811661116d5760405162461bcd60e51b81526004018080602001828103825260268152602001806111b76026913960400191505060405180910390fd5b600080546040516001600160a01b03808516939216916000805160206111fd83398151915291a3600080546001600160a01b0319166001600160a01b039290921691909117905556fe4f776e61626c653a206e6577206f776e657220697320746865207a65726f20616464726573734f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65728be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0a265627a7a72305820d725f5d5175992eec7712e152f3d07ff09584dfcb36fa5dfc898b871fbae13c464736f6c634300050a0032";

    public static final String FUNC_REMOVEFROMWHITELIST = "removeFromWhiteList";

    public static final String FUNC_BETEXSTORAGE = "betexStorage";

    public static final String FUNC_GETCTO = "getCTO";

    public static final String FUNC_GETMARKETMANAGER = "getMarketManager";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_SETMARKETMANAGER = "setMarketManager";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETCTO = "setCTO";

    public static final String FUNC_OPENMARKETWITH2RUNNERS = "openMarketWith2Runners";

    public static final String FUNC_OPENMARKETWITH3RUNNERS = "openMarketWith3Runners";

    public static final String FUNC_SUSPENDMARKET = "suspendMarket";

    public static final String FUNC_CLOSEMARKET = "closeMarket";

    public static final String FUNC_RESOLVEMARKET = "resolveMarket";

    public static final String FUNC_ISWINNER = "isWinner";

    public static final String FUNC_MARKETRUNNEREXISTS = "marketRunnerExists";

    public static final String FUNC_CLOSEEVENT = "closeEvent";

    public static final String FUNC_SUSPENDEVENT = "suspendEvent";

    public static final String FUNC_INIT = "init";

    public static final Event SETTEDCTO_EVENT = new Event("SettedCTO", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event SETTEDMARKETMANAGER_EVENT = new Event("SettedMarketManager", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event REMOVEDFROMWITHELIST_EVENT = new Event("RemovedFromWitheList", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event ADDEDTOLIST_EVENT = new Event("AddedToList", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected BetexLaurasiaGondwana(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BetexLaurasiaGondwana(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BetexLaurasiaGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BetexLaurasiaGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> removeFromWhiteList(String _address) {
        final Function function = new Function(
                FUNC_REMOVEFROMWHITELIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> betexStorage() {
        final Function function = new Function(FUNC_BETEXSTORAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getCTO() {
        final Function function = new Function(FUNC_GETCTO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getMarketManager() {
        final Function function = new Function(FUNC_GETMARKETMANAGER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isOwner() {
        final Function function = new Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setMarketManager(String _marketManager) {
        final Function function = new Function(
                FUNC_SETMARKETMANAGER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_marketManager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setCTO(String _cto) {
        final Function function = new Function(
                FUNC_SETCTO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_cto)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<SettedCTOEventResponse> getSettedCTOEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETTEDCTO_EVENT, transactionReceipt);
        ArrayList<SettedCTOEventResponse> responses = new ArrayList<SettedCTOEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SettedCTOEventResponse typedResponse = new SettedCTOEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SettedCTOEventResponse> settedCTOEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SettedCTOEventResponse>() {
            @Override
            public SettedCTOEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SETTEDCTO_EVENT, log);
                SettedCTOEventResponse typedResponse = new SettedCTOEventResponse();
                typedResponse.log = log;
                typedResponse.newAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SettedCTOEventResponse> settedCTOEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETTEDCTO_EVENT));
        return settedCTOEventFlowable(filter);
    }

    public List<SettedMarketManagerEventResponse> getSettedMarketManagerEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETTEDMARKETMANAGER_EVENT, transactionReceipt);
        ArrayList<SettedMarketManagerEventResponse> responses = new ArrayList<SettedMarketManagerEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SettedMarketManagerEventResponse typedResponse = new SettedMarketManagerEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SettedMarketManagerEventResponse> settedMarketManagerEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SettedMarketManagerEventResponse>() {
            @Override
            public SettedMarketManagerEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SETTEDMARKETMANAGER_EVENT, log);
                SettedMarketManagerEventResponse typedResponse = new SettedMarketManagerEventResponse();
                typedResponse.log = log;
                typedResponse.newAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SettedMarketManagerEventResponse> settedMarketManagerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETTEDMARKETMANAGER_EVENT));
        return settedMarketManagerEventFlowable(filter);
    }

    public List<RemovedFromWitheListEventResponse> getRemovedFromWitheListEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REMOVEDFROMWITHELIST_EVENT, transactionReceipt);
        ArrayList<RemovedFromWitheListEventResponse> responses = new ArrayList<RemovedFromWitheListEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RemovedFromWitheListEventResponse typedResponse = new RemovedFromWitheListEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.removedAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RemovedFromWitheListEventResponse> removedFromWitheListEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, RemovedFromWitheListEventResponse>() {
            @Override
            public RemovedFromWitheListEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REMOVEDFROMWITHELIST_EVENT, log);
                RemovedFromWitheListEventResponse typedResponse = new RemovedFromWitheListEventResponse();
                typedResponse.log = log;
                typedResponse.removedAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RemovedFromWitheListEventResponse> removedFromWitheListEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REMOVEDFROMWITHELIST_EVENT));
        return removedFromWitheListEventFlowable(filter);
    }

    public List<AddedToListEventResponse> getAddedToListEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDEDTOLIST_EVENT, transactionReceipt);
        ArrayList<AddedToListEventResponse> responses = new ArrayList<AddedToListEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedToListEventResponse typedResponse = new AddedToListEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.removedAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddedToListEventResponse> addedToListEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddedToListEventResponse>() {
            @Override
            public AddedToListEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDEDTOLIST_EVENT, log);
                AddedToListEventResponse typedResponse = new AddedToListEventResponse();
                typedResponse.log = log;
                typedResponse.removedAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddedToListEventResponse> addedToListEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDEDTOLIST_EVENT));
        return addedToListEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
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

    public RemoteCall<TransactionReceipt> init(String _betexStorageAddress, String _laurasiaWalletAddress) {
        final Function function = new Function(
                FUNC_INIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_betexStorageAddress), 
                new org.web3j.abi.datatypes.Address(_laurasiaWalletAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BetexLaurasiaGondwana load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BetexLaurasiaGondwana(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BetexLaurasiaGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BetexLaurasiaGondwana(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BetexLaurasiaGondwana load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BetexLaurasiaGondwana(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BetexLaurasiaGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BetexLaurasiaGondwana(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BetexLaurasiaGondwana> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BetexLaurasiaGondwana.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BetexLaurasiaGondwana> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BetexLaurasiaGondwana.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BetexLaurasiaGondwana> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BetexLaurasiaGondwana.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BetexLaurasiaGondwana> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BetexLaurasiaGondwana.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class SettedCTOEventResponse {
        public Log log;

        public String newAddress;
    }

    public static class SettedMarketManagerEventResponse {
        public Log log;

        public String newAddress;
    }

    public static class RemovedFromWitheListEventResponse {
        public Log log;

        public String removedAddress;
    }

    public static class AddedToListEventResponse {
        public Log log;

        public String removedAddress;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
