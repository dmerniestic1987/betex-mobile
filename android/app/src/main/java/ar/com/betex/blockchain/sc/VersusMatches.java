package ar.com.betex.blockchain.sc;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint128;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
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
 * <p>Generated with web3j version 4.3.0.
 */
public class VersusMatches extends Contract {
    private static final String BINARY = "0x6080604081905260008054600160a060020a0319163317808255600160a060020a0316917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a3611186806100576000396000f3fe6080604052600436106100955763ffffffff60e060020a6000350416631273870f811461009a57806314f02fe71461013c57806326c83eff146101dc5780634768d4ef14610223578063715018a6146102fe5780638da5cb5b146103135780638f32d59b146103445780638ffd11211461035957806393f3295614610413578063cc1aad58146104db578063f2fde38b146105a3575b600080fd5b3480156100a657600080fd5b5061013a600480360360a08110156100bd57600080fd5b8135916001608060020a03602082013581169260408301359091169160608101359181019060a081016080820135602060020a8111156100fc57600080fd5b82018360208201111561010e57600080fd5b803590602001918460018302840111602060020a8311171561012f57600080fd5b5090925090506105d6565b005b34801561014857600080fd5b5061013a600480360360a081101561015f57600080fd5b8135916001608060020a03602082013581169260408301359091169160608101359181019060a081016080820135602060020a81111561019e57600080fd5b8201836020820111156101b057600080fd5b803590602001918460018302840111602060020a831117156101d157600080fd5b509092509050610848565b3480156101e857600080fd5b5061020f600480360360208110156101ff57600080fd5b50356001608060020a0316610a73565b604080519115158252519081900360200190f35b34801561022f57600080fd5b5061024d6004803603602081101561024657600080fd5b5035610a91565b60405180856001608060020a03166001608060020a03168152602001846001608060020a03166001608060020a0316815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156102c05781810151838201526020016102a8565b50505050905090810190601f1680156102ed5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561030a57600080fd5b5061013a610b51565b34801561031f57600080fd5b50610328610bd5565b60408051600160a060020a039092168252519081900360200190f35b34801561035057600080fd5b5061020f610be5565b34801561036557600080fd5b5061038c6004803603602081101561037c57600080fd5b50356001608060020a0316610bf6565b604080518415158152908101829052606060208083018281528551928401929092528451608084019186019080838360005b838110156103d65781810151838201526020016103be565b50505050905090810190601f1680156104035780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561041f57600080fd5b5061013a6004803603606081101561043657600080fd5b6001608060020a03823516916020810135151591810190606081016040820135602060020a81111561046757600080fd5b82018360208201111561047957600080fd5b803590602001918460018302840111602060020a8311171561049a57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610ca9945050505050565b3480156104e757600080fd5b5061013a600480360360608110156104fe57600080fd5b6001608060020a03823516916020810135151591810190606081016040820135602060020a81111561052f57600080fd5b82018360208201111561054157600080fd5b803590602001918460018302840111602060020a8311171561056257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610d96945050505050565b3480156105af57600080fd5b5061013a600480360360208110156105c657600080fd5b5035600160a060020a0316610ee1565b6105de610be5565b1515610622576040805160e560020a62461bcd028152602060048201819052602482015260008051602061111b833981519152604482015290519081900360640190fd5b6001608060020a03841660009081526002602052604090205460ff161515610682576040805160e560020a62461bcd02815260206004820181905260248201526000805160206110fb833981519152604482015290519081900360640190fd5b60008681526004602052604090205460ff1615610701576040805160e560020a62461bcd02815260206004820152602c60248201527f4d4830303031204d415443482057495448204c4152554153494120494420414c604482015260a060020a6b52454144592045584953545302606482015290519081900360840190fd5b608060405190810160405280866001608060020a03168152602001856001608060020a0316815260200184815260200183838080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201829052509390945250508881526003602090815260409182902084518154868401516001608060020a03908116608060020a029281166001608060020a03199092169190911716178155918401516001830155606084015180519293506107cf9260028501929190910190610ff4565b5050506000868152600460209081526040808320805460ff191660019081179091556001608060020a0388168452808352928190206002018054909301909255815188815291517f6f4be7994c3a04e452b9088fe64db9fff3d182a0f86c08c7d7e4b611ba6b55f89281900390910190a1505050505050565b610850610be5565b1515610894576040805160e560020a62461bcd028152602060048201819052602482015260008051602061111b833981519152604482015290519081900360640190fd5b6001608060020a03841660009081526002602052604090205460ff1615156108f4576040805160e560020a62461bcd02815260206004820181905260248201526000805160206110fb833981519152604482015290519081900360640190fd5b60008681526004602052604090205460ff161515610971576040805160e560020a62461bcd02815260206004820152602960248201527f4d4830303032204d415443482057495448204c4152554153494120444f455320604482015260ba60020a681393d50811561254d502606482015290519081900360840190fd5b6000868152600360205260409020546001608060020a03858116608060020a90920416146109fb57600086815260036020818152604080842080546001608060020a03608060020a91829004811687526001808652848820600290810180546000190190558c8316808a529589200180549091019055958c90529390925281549202919092161790555b600086815260036020526040902080546001608060020a0319166001608060020a03871617815560018101849055610a37906002018383611072565b506040805187815290517f56dd82d5d9255e0db0058a680e732fd8952a3f06745cbdd7af6e966dd83cae6d9181900360200190a1505050505050565b6001608060020a031660009081526002602052604090205460ff1690565b60036020908152600091825260409182902080546001808301546002808501805488516101009582161595909502600019011691909104601f81018790048702840187019097528683526001608060020a0380851697608060020a90950416959194939091830182828015610b475780601f10610b1c57610100808354040283529160200191610b47565b820191906000526020600020905b815481529060010190602001808311610b2a57829003601f168201915b5050505050905084565b610b59610be5565b1515610b9d576040805160e560020a62461bcd028152602060048201819052602482015260008051602061111b833981519152604482015290519081900360640190fd5b60008054604051600160a060020a039091169060008051602061113b833981519152908390a360008054600160a060020a0319169055565b600054600160a060020a03165b90565b600054600160a060020a0316331490565b600160208181526000928352604092839020805481840180548651600261010097831615979097026000190190911695909504601f810185900485028601850190965285855260ff90911694919392909190830182828015610c995780601f10610c6e57610100808354040283529160200191610c99565b820191906000526020600020905b815481529060010190602001808311610c7c57829003601f168201915b5050505050908060020154905083565b610cb1610be5565b1515610cf5576040805160e560020a62461bcd028152602060048201819052602482015260008051602061111b833981519152604482015290519081900360640190fd5b6001608060020a03831660009081526002602052604090205460ff161515610d55576040805160e560020a62461bcd02815260206004820181905260248201526000805160206110fb833981519152604482015290519081900360640190fd5b6001608060020a0383166000908152600160208181526040909220805460ff19168515151781558351610d9093919092019190840190610ff4565b50505050565b610d9e610be5565b1515610de2576040805160e560020a62461bcd028152602060048201819052602482015260008051602061111b833981519152604482015290519081900360640190fd5b6001608060020a03831660009081526002602052604090205460ff1615610e51576040805160e560020a62461bcd0281526020600482015260186024820152604060020a774d5430303031204d4154434820545950452045584953545302604482015290519081900360640190fd5b604080516060810182528315158152602080820184815260008385018190526001608060020a038816815260018084529490208351815460ff19169015151781559051805193949193610eac93928501929190910190610ff4565b506040918201516002918201556001608060020a039094166000908152602094909452909220805460ff191660011790555050565b610ee9610be5565b1515610f2d576040805160e560020a62461bcd028152602060048201819052602482015260008051602061111b833981519152604482015290519081900360640190fd5b610f3681610f39565b50565b600160a060020a0381161515610fab576040805160e560020a62461bcd02815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f2061604482015260d060020a6564647265737302606482015290519081900360840190fd5b60008054604051600160a060020a038085169392169160008051602061113b83398151915291a360008054600160a060020a031916600160a060020a0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061103557805160ff1916838001178555611062565b82800160010185558215611062579182015b82811115611062578251825591602001919060010190611047565b5061106e9291506110e0565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106110b35782800160ff19823516178555611062565b82800160010185558215611062579182015b828111156110625782358255916020019190600101906110c5565b610be291905b8082111561106e57600081556001016110e656fe4d5430303032204d41544348205459504520444f4553204e4f542045584953544f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65728be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0a165627a7a723058208744e0c268ae6e7e843a72e5f2ea95a274b92bd25916830b369aa0c1e431b8040029";

    public static final String FUNC_MATCHES = "matches";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_MATCHTYPES = "matchTypes";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_MATCHTYPEEXISTS = "matchTypeExists";

    public static final String FUNC_ADDMATCHTYPE = "addMatchType";

    public static final String FUNC_UPDATEMATCHTYPE = "updateMatchType";

    public static final String FUNC_CREATEMATCH = "createMatch";

    public static final String FUNC_UPDATEMATCH = "updateMatch";

    public static final Event NEWMATCH_EVENT = new Event("NewMatch", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event UPDATEMATCH_EVENT = new Event("UpdateMatch", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected VersusMatches(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VersusMatches(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VersusMatches(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VersusMatches(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, String>> matches(BigInteger param0) {
        final Function function = new Function(FUNC_MATCHES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}, new TypeReference<Uint128>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, String>>(
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
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

    public RemoteCall<Tuple3<Boolean, String, BigInteger>> matchTypes(BigInteger param0) {
        final Function function = new Function(FUNC_MATCHTYPES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint128(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<Boolean, String, BigInteger>>(
                new Callable<Tuple3<Boolean, String, BigInteger>>() {
                    @Override
                    public Tuple3<Boolean, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<Boolean, String, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<NewMatchEventResponse> getNewMatchEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWMATCH_EVENT, transactionReceipt);
        ArrayList<NewMatchEventResponse> responses = new ArrayList<NewMatchEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewMatchEventResponse typedResponse = new NewMatchEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.idLaurasia = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewMatchEventResponse> newMatchEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, NewMatchEventResponse>() {
            @Override
            public NewMatchEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWMATCH_EVENT, log);
                NewMatchEventResponse typedResponse = new NewMatchEventResponse();
                typedResponse.log = log;
                typedResponse.idLaurasia = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewMatchEventResponse> newMatchEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWMATCH_EVENT));
        return newMatchEventFlowable(filter);
    }

    public List<UpdateMatchEventResponse> getUpdateMatchEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UPDATEMATCH_EVENT, transactionReceipt);
        ArrayList<UpdateMatchEventResponse> responses = new ArrayList<UpdateMatchEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UpdateMatchEventResponse typedResponse = new UpdateMatchEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.idLaurasia = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UpdateMatchEventResponse> updateMatchEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, UpdateMatchEventResponse>() {
            @Override
            public UpdateMatchEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UPDATEMATCH_EVENT, log);
                UpdateMatchEventResponse typedResponse = new UpdateMatchEventResponse();
                typedResponse.log = log;
                typedResponse.idLaurasia = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UpdateMatchEventResponse> updateMatchEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UPDATEMATCH_EVENT));
        return updateMatchEventFlowable(filter);
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

    public RemoteCall<Boolean> matchTypeExists(BigInteger _matchTypeId) {
        final Function function = new Function(FUNC_MATCHTYPEEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint128(_matchTypeId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> addMatchType(BigInteger _matchTypeId, Boolean _canDraw, String _description) {
        final Function function = new Function(
                FUNC_ADDMATCHTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint128(_matchTypeId), 
                new org.web3j.abi.datatypes.Bool(_canDraw), 
                new org.web3j.abi.datatypes.Utf8String(_description)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updateMatchType(BigInteger _matchTypeId, Boolean _canDraw, String _description) {
        final Function function = new Function(
                FUNC_UPDATEMATCHTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint128(_matchTypeId), 
                new org.web3j.abi.datatypes.Bool(_canDraw), 
                new org.web3j.abi.datatypes.Utf8String(_description)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createMatch(BigInteger _idLaurasia, BigInteger _idCompetition, BigInteger _idMatchType, BigInteger _startDateTimestamp, String _countryCode) {
        final Function function = new Function(
                FUNC_CREATEMATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idLaurasia), 
                new org.web3j.abi.datatypes.generated.Uint128(_idCompetition), 
                new org.web3j.abi.datatypes.generated.Uint128(_idMatchType), 
                new org.web3j.abi.datatypes.generated.Uint256(_startDateTimestamp), 
                new org.web3j.abi.datatypes.Utf8String(_countryCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updateMatch(BigInteger _idLaurasia, BigInteger _idCompetition, BigInteger _idMatchType, BigInteger _startDateTimestamp, String _countryCode) {
        final Function function = new Function(
                FUNC_UPDATEMATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idLaurasia), 
                new org.web3j.abi.datatypes.generated.Uint128(_idCompetition), 
                new org.web3j.abi.datatypes.generated.Uint128(_idMatchType), 
                new org.web3j.abi.datatypes.generated.Uint256(_startDateTimestamp), 
                new org.web3j.abi.datatypes.Utf8String(_countryCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static VersusMatches load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VersusMatches(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VersusMatches load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VersusMatches(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VersusMatches load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VersusMatches(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VersusMatches load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VersusMatches(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VersusMatches> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VersusMatches.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VersusMatches> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VersusMatches.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<VersusMatches> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(VersusMatches.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<VersusMatches> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(VersusMatches.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class NewMatchEventResponse {
        public Log log;

        public BigInteger idLaurasia;
    }

    public static class UpdateMatchEventResponse {
        public Log log;

        public BigInteger idLaurasia;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
