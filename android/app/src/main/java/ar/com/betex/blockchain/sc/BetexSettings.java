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
 * <p>Generated with web3j version 4.2.0.
 */
public class BetexSettings extends Contract {
    private static final String BINARY = "0x60806040819052600080546001600160a01b03191633178082556001600160a01b0316917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a3611870806100576000396000f3fe608060405234801561001057600080fd5b506004361061021a5760003560e01c806301bf66481461021f578063077052581461024757806312e9e5fc146102bf578063133691d5146102d95780631faeb3d3146102e157806321b3996f146102fe578063223f8a471461031b57806329bb6eae146103235780632a4591241461032b578063347e882e1461033357806339e7400b14610350578063433fac85146103585780634703b1531461037c578063480324a8146103845780634cbfddd8146103a15780635413dee6146103be578063556cca6e146103f657806357571e26146103fe578063715018a61461041b57806373fbdde4146104235780637ef8513a146104405780638da5cb5b1461048e5780638f32d59b1461049657806390179980146104b257806391701b8e146104cf57806391c115a2146104d7578063959d985a146104df5780639cea09e4146104e75780639d93198f146104ef578063abfa3e3814610533578063ac8a66f41461053b578063b4abf99814610558578063bc5ae59a14610560578063bf5749d414610568578063c513094614610570578063d45b244914610578578063d82aff1114610580578063da4df8f8146105a6578063ddbb5cc6146105ae578063e7001142146105b6578063e86af7d9146105be578063eba234ea146105c6578063f2fde38b146105ce578063f60fa213146105f4578063f9af438914610611578063fe1439b41461062e575b600080fd5b6102456004803603602081101561023557600080fd5b50356001600160a01b0316610654565b005b61024560048036036101a081101561025e57600080fd5b506001600160a01b03813581169160208101359091169060408101359060608101359060808101359060a08101359060c08101359060e081013590610100810135906101208101359061014081013590610160810135906101800135610752565b6102c7610848565b60408051918252519081900360200190f35b6102c761084e565b610245600480360360208110156102f757600080fd5b50356108a7565b6102456004803603602081101561031457600080fd5b50356108f3565b6102c761093f565b6102c7610945565b6102c761094b565b6102456004803603602081101561034957600080fd5b5035610951565b6102c761099d565b6103606109a3565b604080516001600160a01b039092168252519081900360200190f35b6102c76109fc565b6102456004803603602081101561039a57600080fd5b5035610a55565b610245600480360360208110156103b757600080fd5b5035610aa1565b610245600480360360808110156103d457600080fd5b506001600160a01b038135169060208101359060408101359060600135610aed565b610360610ca7565b6102456004803603602081101561041457600080fd5b5035610d00565b610245610d4c565b6102456004803603602081101561043957600080fd5b5035610dcb565b6104666004803603602081101561045657600080fd5b50356001600160a01b0316610e17565b6040805194855260208501939093528383019190915215156060830152519081900360800190f35b610360610e41565b61049e610e50565b604080519115158252519081900360200190f35b610245600480360360208110156104c857600080fd5b5035610e61565b6102c7610ead565b6102c7610f06565b6102c7610f5f565b6102c7610f65565b6105156004803603602081101561050557600080fd5b50356001600160a01b0316610f6b565b60408051938452602084019290925282820152519081900360600190f35b6102c761102b565b6102456004803603602081101561055157600080fd5b5035611084565b6102c76110d0565b6102c7611129565b6102c7611182565b6102c76111db565b6102c7611234565b6102456004803603602081101561059657600080fd5b50356001600160a01b031661128d565b6102c761139c565b6102c76113a2565b6102c76113fb565b6102c7611401565b6102c7611407565b610245600480360360208110156105e457600080fd5b50356001600160a01b031661140d565b6102456004803603602081101561060a57600080fd5b5035611460565b6102456004803603602081101561062757600080fd5b50356114ac565b6102456004803603602081101561064457600080fd5b50356001600160a01b03166114f8565b61065c610e50565b61069b576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b6001600160a01b03811660009081526003602052604090205460ff166106fa576040805162461bcd60e51b815260206004820152600f60248201526e139bdd081dda5d1a195b1a5cdd1959608a1b604482015290519081900360640190fd5b6001600160a01b038116600081815260036020908152604091829020805460ff19169055815192835290517fffe6b8088a5bb820a86181b172a4fc5d5ec985ed70b88e0815e76e5480d55c819281900390910190a150565b60045460ff16156107a9576040805162461bcd60e51b815260206004820152601c60248201527b10dbdb9d1c9858dd08185b1c9958591e481a5b9a5d1a585b1a5e995960221b604482015290519081900360640190fd5b6107b1610e50565b6107f0576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b60058b905560068a9055600789905560098890556008879055600a869055600b859055600c849055600d839055600e829055600f8190556108308d6115ff565b6108398c6115ff565b50505050505050505050505050565b60055481565b3360009081526003602052604081205460ff166108a0576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b50600d5490565b6108af610e50565b6108ee576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600c55565b6108fb610e50565b61093a576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600d55565b600b5481565b60095481565b600a5481565b610959610e50565b610998576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600a55565b60065481565b60006109ad610e50565b6109ec576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b506002546001600160a01b031690565b3360009081526003602052604081205460ff16610a4e576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b5060065490565b610a5d610e50565b610a9c576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600955565b610aa9610e50565b610ae8576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600855565b3360009081526003602052604090205460ff16610b3f576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b6009548311610b7f5760405162461bcd60e51b81526004018080602001828103825260318152602001806117e46031913960400191505060405180910390fd5b6008548211610bbf5760405162461bcd60e51b81526004018080602001828103825260318152602001806117736031913960400191505060405180910390fd5b60008111610bfe5760405162461bcd60e51b81526004018080602001828103825260278152602001806118156027913960400191505060405180910390fd5b604080516080810182528481526020808201858152828401858152600160608086018281526001600160a01b038c16600090815260108752889020965187559351918601919091559051600285015590516003909301805460ff191693151593909317909255825186815290810185905280830184905291517f3a3440694e880532638f486375a3e6e97ba0a4c1cbbc5e01392fba512a26a4899281900390910190a150505050565b6000610cb1610e50565b610cf0576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b506001546001600160a01b031690565b610d08610e50565b610d47576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600555565b610d54610e50565b610d93576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600080546040516001600160a01b03909116906000805160206117c4833981519152908390a3600080546001600160a01b0319169055565b610dd3610e50565b610e12576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600755565b60106020526000908152604090208054600182015460028301546003909301549192909160ff1684565b6000546001600160a01b031690565b6000546001600160a01b0316331490565b610e69610e50565b610ea8576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600e55565b3360009081526003602052604081205460ff16610eff576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b50600e5490565b3360009081526003602052604081205460ff16610f58576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b5060085490565b600f5481565b60085481565b336000908152600360205260408120548190819060ff16610fc1576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b6001600160a01b03841660009081526010602052604090206003015460ff16610ff857600554600654600754925092509250611024565b5050506001600160a01b0381166000908152601060205260409020805460018201546002909201549091905b9193909250565b3360009081526003602052604081205460ff1661107d576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b50600b5490565b61108c610e50565b6110cb576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600f55565b3360009081526003602052604081205460ff16611122576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b5060095490565b3360009081526003602052604081205460ff1661117b576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b5060055490565b3360009081526003602052604081205460ff166111d4576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b50600a5490565b3360009081526003602052604081205460ff1661122d576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b50600c5490565b3360009081526003602052604081205460ff16611286576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b5060075490565b611295610e50565b6112d4576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b6112dc610e41565b6001600160a01b0316816001600160a01b03161415611342576040805162461bcd60e51b815260206004820152601f60248201527f4f6e776572206d757374206e6f74206265204d61726b65744d616e6167657200604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b03838116919091179182905560408051929091168252517f4b7398b309ffc44650cb39cb11a622b3d7bea9f1a262dbcb62385598a4497bdf916020908290030190a150565b600e5481565b3360009081526003602052604081205460ff166113f4576040805162461bcd60e51b815260206004820152600b60248201526a139bdd08185b1b1bddd95960aa1b604482015290519081900360640190fd5b50600f5490565b600d5481565b60075481565b600c5481565b611415610e50565b611454576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b61145d816116be565b50565b611468610e50565b6114a7576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600655565b6114b4610e50565b6114f3576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b600b55565b611500610e50565b61153f576040805162461bcd60e51b815260206004820181905260248201526000805160206117a4833981519152604482015290519081900360640190fd5b611547610e41565b6001600160a01b0316816001600160a01b031614156115a5576040805162461bcd60e51b81526020600482015260156024820152744f6e776572206d757374206e6f742062652043544f60581b604482015290519081900360640190fd5b600280546001600160a01b0319166001600160a01b03838116919091179182905560408051929091168252517f3278084dec868221e78ff53abc452308624a817c9513c85687d76c12ecb87873916020908290030190a150565b6001600160a01b03811660009081526003602052604090205460ff1615611663576040805162461bcd60e51b8152602060048201526013602482015272105b1c9958591e481dda5d1a195b1a5cdd1959606a1b604482015290519081900360640190fd5b6001600160a01b038116600081815260036020908152604091829020805460ff19166001179055815192835290517f832f053a3bb9766e023641dae65836917ded9bd6110f5854a0ba2b93ce32d5e09281900390910190a150565b6001600160a01b0381166117035760405162461bcd60e51b815260040180806020018281038252602681526020018061174d6026913960400191505060405180910390fd5b600080546040516001600160a01b03808516939216916000805160206117c483398151915291a3600080546001600160a01b0319166001600160a01b039290921691909117905556fe4f776e61626c653a206e6577206f776e657220697320746865207a65726f20616464726573734d61782062747820616d6f756e742063616e206e6f7420626574206c6f776572207468616e206d696e5374616b654274784f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65728be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e04d61782077656920616d6f756e742063616e206e6f7420626574206c6f776572207468616e206d696e5374616b655765694d617820626574207065722064617973206d7573742062652067726561746572207468616e2030a265627a7a7230582088e33747f9e5ad2ffdb493cab7b7215599e586d1822e6b6fe61ef53866716eb364736f6c634300050a0032";

    public static final String FUNC_REMOVEFROMWHITELIST = "removeFromWhiteList";

    public static final String FUNC_DEFAULTMAXAMOUNTWEIPERDAY = "defaultMaxAmountWeiPerDay";

    public static final String FUNC_MAXSTAKEWEI = "maxStakeWei";

    public static final String FUNC_MINSTAKEWEI = "minStakeWei";

    public static final String FUNC_MAXSTAKEBTX = "maxStakeBtx";

    public static final String FUNC_DEFAULTMAXAMOUNTBTXPERDAY = "defaultMaxAmountBtxPerDay";

    public static final String FUNC_GETCTO = "getCTO";

    public static final String FUNC_GETMARKETMANAGER = "getMarketManager";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_USERSETTINGS = "userSettings";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_COMISSIONCANCELBETBTX = "comissionCancelBetBtx";

    public static final String FUNC_MINSTAKEBTX = "minStakeBtx";

    public static final String FUNC_SETMARKETMANAGER = "setMarketManager";

    public static final String FUNC_COMISSIONWINNERBETBTX = "comissionWinnerBetBtx";

    public static final String FUNC_COMISSIONCANCELBETWEI = "comissionCancelBetWei";

    public static final String FUNC_DEFAULTMAXBETSPERDAY = "defaultMaxBetsPerDay";

    public static final String FUNC_COMISSIONWINNERBETWEI = "comissionWinnerBetWei";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETCTO = "setCTO";

    public static final String FUNC_GETUSERSETTINGS = "getUserSettings";

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

    public static final String FUNC_SAVEUSERSETTINGS = "saveUserSettings";

    public static final String FUNC_SETDEFAULTMAXAMOUNTWEIPERDAY = "setDefaultMaxAmountWeiPerDay";

    public static final String FUNC_SETDEFAULTMAXAMOUNTBTXPERDAY = "setDefaultMaxAmountBtxPerDay";

    public static final String FUNC_SETDEFAULTMAXBETSPERDAY = "setDefaultMaxBetsPerDay";

    public static final String FUNC_SETMINSTAKEWEI = "setMinStakeWei";

    public static final String FUNC_SETMINSTAKEBTX = "setMinStakeBtx";

    public static final String FUNC_SETMAXSTAKEWEI = "setMaxStakeWei";

    public static final String FUNC_SETMAXSTAKEBTX = "setMaxStakeBtx";

    public static final String FUNC_SETCOMISSIONWINNERBETWEI = "setComissionWinnerBetWei";

    public static final String FUNC_SETCOMISSIONCANCELBETWEI = "setComissionCancelBetWei";

    public static final String FUNC_SETCOMISSIONWINNERBETBTX = "setComissionWinnerBetBtx";

    public static final String FUNC_SETCOMISSIONCANCELBETBTX = "setComissionCancelBetBtx";

    public static final String FUNC_INIT = "init";

    public static final Event USERSETTINGSUPDATE_EVENT = new Event("UserSettingsUpdate", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

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
    protected BetexSettings(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BetexSettings(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BetexSettings(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BetexSettings(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> removeFromWhiteList(String _address) {
        final Function function = new Function(
                FUNC_REMOVEFROMWHITELIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> defaultMaxAmountWeiPerDay() {
        final Function function = new Function(FUNC_DEFAULTMAXAMOUNTWEIPERDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> maxStakeWei() {
        final Function function = new Function(FUNC_MAXSTAKEWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> minStakeWei() {
        final Function function = new Function(FUNC_MINSTAKEWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> maxStakeBtx() {
        final Function function = new Function(FUNC_MAXSTAKEBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> defaultMaxAmountBtxPerDay() {
        final Function function = new Function(FUNC_DEFAULTMAXAMOUNTBTXPERDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, Boolean>> userSettings(String param0) {
        final Function function = new Function(FUNC_USERSETTINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple4<BigInteger, BigInteger, BigInteger, Boolean>>(
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, Boolean>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, Boolean>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue());
                    }
                });
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

    public RemoteCall<BigInteger> comissionCancelBetBtx() {
        final Function function = new Function(FUNC_COMISSIONCANCELBETBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> minStakeBtx() {
        final Function function = new Function(FUNC_MINSTAKEBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setMarketManager(String _marketManager) {
        final Function function = new Function(
                FUNC_SETMARKETMANAGER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_marketManager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> comissionWinnerBetBtx() {
        final Function function = new Function(FUNC_COMISSIONWINNERBETBTX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> comissionCancelBetWei() {
        final Function function = new Function(FUNC_COMISSIONCANCELBETWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> defaultMaxBetsPerDay() {
        final Function function = new Function(FUNC_DEFAULTMAXBETSPERDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> comissionWinnerBetWei() {
        final Function function = new Function(FUNC_COMISSIONWINNERBETWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public List<UserSettingsUpdateEventResponse> getUserSettingsUpdateEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(USERSETTINGSUPDATE_EVENT, transactionReceipt);
        ArrayList<UserSettingsUpdateEventResponse> responses = new ArrayList<UserSettingsUpdateEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UserSettingsUpdateEventResponse typedResponse = new UserSettingsUpdateEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.amountWeiPerDay = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountBtxPerDay = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.maxBetsPerDay = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UserSettingsUpdateEventResponse> userSettingsUpdateEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, UserSettingsUpdateEventResponse>() {
            @Override
            public UserSettingsUpdateEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(USERSETTINGSUPDATE_EVENT, log);
                UserSettingsUpdateEventResponse typedResponse = new UserSettingsUpdateEventResponse();
                typedResponse.log = log;
                typedResponse.amountWeiPerDay = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountBtxPerDay = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.maxBetsPerDay = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UserSettingsUpdateEventResponse> userSettingsUpdateEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(USERSETTINGSUPDATE_EVENT));
        return userSettingsUpdateEventFlowable(filter);
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

    public RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>> getUserSettings(String _userAddress) {
        final Function function = new Function(FUNC_GETUSERSETTINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_userAddress)), 
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

    public RemoteCall<BigInteger> getDefaultMaxAmountWeiPerDay() {
        final Function function = new Function(FUNC_GETDEFAULTMAXAMOUNTWEIPERDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getDefaultMaxAmountBtxPerDay() {
        final Function function = new Function(FUNC_GETDEFAULTMAXAMOUNTBTXPERDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getDefaultMaxBetsPerDay() {
        final Function function = new Function(FUNC_GETDEFAULTMAXBETSPERDAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<TransactionReceipt> saveUserSettings(String _userAddress, BigInteger _maxAmountWeiPerDay, BigInteger _maxAmountBtxPerDay, BigInteger _maxBetsPerDay) {
        final Function function = new Function(
                FUNC_SAVEUSERSETTINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_userAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxAmountWeiPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxAmountBtxPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxBetsPerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDefaultMaxAmountWeiPerDay(BigInteger _amount) {
        final Function function = new Function(
                FUNC_SETDEFAULTMAXAMOUNTWEIPERDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDefaultMaxAmountBtxPerDay(BigInteger _amount) {
        final Function function = new Function(
                FUNC_SETDEFAULTMAXAMOUNTBTXPERDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setDefaultMaxBetsPerDay(BigInteger _maxBetsPerDay) {
        final Function function = new Function(
                FUNC_SETDEFAULTMAXBETSPERDAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_maxBetsPerDay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setMinStakeWei(BigInteger _minStakeWei) {
        final Function function = new Function(
                FUNC_SETMINSTAKEWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minStakeWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setMinStakeBtx(BigInteger _minStakeBtx) {
        final Function function = new Function(
                FUNC_SETMINSTAKEBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_minStakeBtx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setMaxStakeWei(BigInteger _maxStakeWei) {
        final Function function = new Function(
                FUNC_SETMAXSTAKEWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_maxStakeWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setMaxStakeBtx(BigInteger _maxStakeBtx) {
        final Function function = new Function(
                FUNC_SETMAXSTAKEBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_maxStakeBtx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setComissionWinnerBetWei(BigInteger _comissionWinnerBetWei) {
        final Function function = new Function(
                FUNC_SETCOMISSIONWINNERBETWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_comissionWinnerBetWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setComissionCancelBetWei(BigInteger _comissionCancelBetWei) {
        final Function function = new Function(
                FUNC_SETCOMISSIONCANCELBETWEI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_comissionCancelBetWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setComissionWinnerBetBtx(BigInteger _comissionWinnerBetBtx) {
        final Function function = new Function(
                FUNC_SETCOMISSIONWINNERBETBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_comissionWinnerBetBtx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setComissionCancelBetBtx(BigInteger _comissionCancelBetBtx) {
        final Function function = new Function(
                FUNC_SETCOMISSIONCANCELBETBTX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_comissionCancelBetBtx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> init(String _betexMobileAddress, String _betexCoreAddress, BigInteger _defaultMaxAmountWeiPerDay, BigInteger _defaultMaxAmountBtxPerDay, BigInteger _defaultMaxBetsPerDay, BigInteger _minStakeWei, BigInteger _minStakeBtx, BigInteger _maxStakeBtx, BigInteger _maxStakeWei, BigInteger _comissionWinnerBetWei, BigInteger _comissionCancelBetWei, BigInteger _comissionWinnerBetBtx, BigInteger _comissionCancelBetBtx) {
        final Function function = new Function(
                FUNC_INIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_betexMobileAddress), 
                new org.web3j.abi.datatypes.Address(_betexCoreAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_defaultMaxAmountWeiPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_defaultMaxAmountBtxPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_defaultMaxBetsPerDay), 
                new org.web3j.abi.datatypes.generated.Uint256(_minStakeWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_minStakeBtx), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxStakeBtx), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxStakeWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_comissionWinnerBetWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_comissionCancelBetWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_comissionWinnerBetBtx), 
                new org.web3j.abi.datatypes.generated.Uint256(_comissionCancelBetBtx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BetexSettings load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BetexSettings(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BetexSettings load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BetexSettings(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BetexSettings load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BetexSettings(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BetexSettings load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BetexSettings(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BetexSettings> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BetexSettings.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BetexSettings> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BetexSettings.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BetexSettings> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BetexSettings.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BetexSettings> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BetexSettings.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class UserSettingsUpdateEventResponse {
        public Log log;

        public BigInteger amountWeiPerDay;

        public BigInteger amountBtxPerDay;

        public BigInteger maxBetsPerDay;
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
