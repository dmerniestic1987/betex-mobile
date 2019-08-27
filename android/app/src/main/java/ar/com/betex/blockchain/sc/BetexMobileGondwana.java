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
public class BetexMobileGondwana extends Contract {
    private static final String BINARY = "0x60806040819052600080546001600160a01b03191633178082556001600160a01b0316917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a3611adf806100576000396000f3fe6080604052600436106101d65760003560e01c80630128992c146101db57806301bf6648146102075780630ae4f47b1461023a5780630e39228814610264578063133691d5146102a257806315c03f31146102c9578063184b9559146102f95780632e0a66701461033e578063433fac851461036f57806346efcf78146103845780634703b153146103a15780634d32f5df146103b6578063527caadc146103f4578063556cca6e14610437578063643e3a741461044c578063715018a6146104695780637b9492881461047e5780637c03f805146104935780638383eedb146104bd5780638da5cb5b146104d25780638f32d59b146104e75780638f610ef7146104fc57806391701b8e1461053257806391c115a214610547578063abfa3e381461055c578063b187bd2614610571578063b4abf99814610586578063b9c440211461059b578063bc5ae59a146105cc578063bf5749d4146105e1578063c5130946146105f6578063c6032fa91461060b578063d45b24491461063e578063d82aff1114610653578063da2ff5bd14610686578063dc427991146106b6578063ddbb5cc6146106e0578063e5e4d05a146106f5578063f2fde38b1461071f578063f4b4b55714610752578063fe1439b414610767575b600080fd5b3480156101e757600080fd5b50610205600480360360208110156101fe57600080fd5b503561079a565b005b34801561021357600080fd5b506102056004803603602081101561022a57600080fd5b50356001600160a01b0316610808565b34801561024657600080fd5b506102056004803603602081101561025d57600080fd5b5035610906565b34801561027057600080fd5b5061028e6004803603602081101561028757600080fd5b5035610959565b604080519115158252519081900360200190f35b3480156102ae57600080fd5b506102b761095f565b60408051918252519081900360200190f35b3480156102d557600080fd5b50610205600480360360408110156102ec57600080fd5b50803590602001356109e0565b34801561030557600080fd5b506102056004803603606081101561031c57600080fd5b506001600160a01b038135811691602081013582169160409091013516610b19565b34801561034a57600080fd5b50610353610bff565b604080516001600160a01b039092168252519081900360200190f35b34801561037b57600080fd5b50610353610c13565b6102056004803603602081101561039a57600080fd5b5035610c6c565b3480156103ad57600080fd5b506102b7610d89565b3480156103c257600080fd5b50610205600480360360808110156103d957600080fd5b50803590602081013590604081013590606001351515610dd9565b34801561040057600080fd5b5061041e6004803603602081101561041757600080fd5b5035610e62565b6040805192835260208301919091528051918290030190f35b34801561044357600080fd5b50610353610eeb565b6102056004803603602081101561046257600080fd5b5035610f44565b34801561047557600080fd5b50610205610fbb565b34801561048a57600080fd5b5061035361103a565b34801561049f57600080fd5b50610205600480360360208110156104b657600080fd5b5035611049565b3480156104c957600080fd5b5061035361109c565b3480156104de57600080fd5b506103536110ab565b3480156104f357600080fd5b5061028e6110ba565b34801561050857600080fd5b506102056004803603606081101561051f57600080fd5b50803590602081013590604001356110cb565b34801561053e57600080fd5b506102b7611131565b34801561055357600080fd5b506102b7611181565b34801561056857600080fd5b506102b76111d1565b34801561057d57600080fd5b5061028e611221565b34801561059257600080fd5b506102b7611226565b610205600480360360808110156105b157600080fd5b50803590602081013590604081013590606001351515611276565b3480156105d857600080fd5b506102b76112fd565b3480156105ed57600080fd5b506102b761134d565b34801561060257600080fd5b506102b761139d565b34801561061757600080fd5b506106206113ed565b60408051938452602084019290925282820152519081900360600190f35b34801561064a57600080fd5b506102b76114a0565b34801561065f57600080fd5b506102056004803603602081101561067657600080fd5b50356001600160a01b03166114f0565b34801561069257600080fd5b50610205600480360360408110156106a957600080fd5b50803590602001356115ff565b3480156106c257600080fd5b50610205600480360360208110156106d957600080fd5b503561171b565b3480156106ec57600080fd5b506102b761176e565b34801561070157600080fd5b506102056004803603602081101561071857600080fd5b50356117be565b34801561072b57600080fd5b506102056004803603602081101561074257600080fd5b50356001600160a01b0316611811565b34801561075e57600080fd5b5061028e611864565b34801561077357600080fd5b506102056004803603602081101561078a57600080fd5b50356001600160a01b03166118af565b60065460408051631fb7384f60e31b81523360048201526024810184905290516001600160a01b039092169163fdb9c2789160448082019260009290919082900301818387803b1580156107ed57600080fd5b505af1158015610801573d6000803e3d6000fd5b5050505050565b6108106110ba565b61084f576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b6001600160a01b03811660009081526003602052604090205460ff166108ae576040805162461bcd60e51b815260206004820152600f60248201526e139bdd081dda5d1a195b1a5cdd1959608a1b604482015290519081900360640190fd5b6001600160a01b038116600081815260036020908152604091829020805460ff19169055815192835290517fffe6b8088a5bb820a86181b172a4fc5d5ec985ed70b88e0815e76e5480d55c819281900390910190a150565b60065460408051631fc3665d60e31b81523360048201526024810184905290516001600160a01b039092169163fe1b32e89160448082019260009290919082900301818387803b1580156107ed57600080fd5b50600090565b6000600460019054906101000a90046001600160a01b03166001600160a01b031663133691d56040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b505afa1580156109c3573d6000803e3d6000fd5b505050506040513d60208110156109d957600080fd5b5051905090565b60055460408051631c771c6960e21b81523360048201819052915191926001600160a01b0316916371dc71a491602480820192602092909190829003018186803b158015610a2d57600080fd5b505afa158015610a41573d6000803e3d6000fd5b505050506040513d6020811015610a5757600080fd5b505115610aa2576040805162461bcd60e51b815260206004820152601460248201527329b2b6331032bc31b63ab232b2103132ba3a32b960611b604482015290519081900360640190fd5b60065460408051630fea8a5560e11b8152336004820152602481018690526044810185905290516001600160a01b0390921691631fd514aa9160648082019260009290919082900301818387803b158015610afc57600080fd5b505af1158015610b10573d6000803e3d6000fd5b50505050505050565b60045460ff1615610b70576040805162461bcd60e51b815260206004820152601c60248201527b10dbdb9d1c9858dd08185b1c9958591e481a5b9a5d1a585b1a5e995960221b604482015290519081900360640190fd5b610b786110ba565b610bb7576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b600480546001600160a01b0394851661010002610100600160a81b0319909116179055600580549284166001600160a01b031993841617905560068054919093169116179055565b60045461010090046001600160a01b031681565b6000610c1d6110ba565b610c5c576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b506002546001600160a01b031690565b60055460408051631c771c6960e21b81523360048201819052915191926001600160a01b0316916371dc71a491602480820192602092909190829003018186803b158015610cb957600080fd5b505afa158015610ccd573d6000803e3d6000fd5b505050506040513d6020811015610ce357600080fd5b505115610d2e576040805162461bcd60e51b815260206004820152601460248201527329b2b6331032bc31b63ab232b2103132ba3a32b960611b604482015290519081900360640190fd5b60065460408051630f128a1560e41b8152336004820152602481018590523460448201819052915191926001600160a01b03169163f128a1509160648082019260009290919082900301818387803b158015610afc57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b0316634703b1536040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b60065460408051600161060960e81b03198152336004820152602481018790526044810186905260648101859052831515608482015290516001600160a01b039092169163fff9f7009160a48082019260009290919082900301818387803b158015610e4457600080fd5b505af1158015610e58573d6000803e3d6000fd5b5050505050505050565b6006546040805163149f2ab760e21b815260048101849052815160009384936001600160a01b039091169263527caadc9260248083019392829003018186803b158015610eae57600080fd5b505afa158015610ec2573d6000803e3d6000fd5b505050506040513d6040811015610ed857600080fd5b5080516020909101519092509050915091565b6000610ef56110ba565b610f34576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b506001546001600160a01b031690565b6006546040805163b826336f60e01b8152336004820152602481018490523460448201819052915191926001600160a01b03169163b826336f9160648082019260009290919082900301818387803b158015610f9f57600080fd5b505af1158015610fb3573d6000803e3d6000fd5b505050505050565b610fc36110ba565b611002576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b600080546040516001600160a01b0390911690600080516020611a8b833981519152908390a3600080546001600160a01b0319169055565b6006546001600160a01b031681565b600654604080516312c995fb60e11b81523360048201526024810184905290516001600160a01b03909216916325932bf69160448082019260009290919082900301818387803b1580156107ed57600080fd5b6005546001600160a01b031681565b6000546001600160a01b031690565b6000546001600160a01b0316331490565b6004805460408051632a09ef7360e11b81523393810193909352602483018690526044830185905260648301849052516101009091046001600160a01b031691635413dee691608480830192600092919082900301818387803b158015610afc57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b03166391701b8e6040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b03166391c115a26040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b031663abfa3e386040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b600090565b6000600460019054906101000a90046001600160a01b03166001600160a01b031663b4abf9986040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b60065460408051631860075160e31b81523360048201526024810187905260448101869052606481018590528315156084820152905134926001600160a01b03169163c3003a889160a480830192600092919082900301818387803b1580156112de57600080fd5b505af11580156112f2573d6000803e3d6000fd5b505050505050505050565b6000600460019054906101000a90046001600160a01b03166001600160a01b031663bc5ae59a6040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b031663bf5749d46040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b031663c51309466040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b6000806000600460019054906101000a90046001600160a01b03166001600160a01b0316639d93198f336040518263ffffffff1660e01b815260040180826001600160a01b03166001600160a01b0316815260200191505060606040518083038186803b15801561145d57600080fd5b505afa158015611471573d6000803e3d6000fd5b505050506040513d606081101561148757600080fd5b5080516020820151604090920151909591945092509050565b6000600460019054906101000a90046001600160a01b03166001600160a01b031663d45b24496040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b6114f86110ba565b611537576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b61153f6110ab565b6001600160a01b0316816001600160a01b031614156115a5576040805162461bcd60e51b815260206004820152601f60248201527f4f6e776572206d757374206e6f74206265204d61726b65744d616e6167657200604482015290519081900360640190fd5b600180546001600160a01b0319166001600160a01b03838116919091179182905560408051929091168252517f4b7398b309ffc44650cb39cb11a622b3d7bea9f1a262dbcb62385598a4497bdf916020908290030190a150565b60055460408051631c771c6960e21b81523360048201819052915191926001600160a01b0316916371dc71a491602480820192602092909190829003018186803b15801561164c57600080fd5b505afa158015611660573d6000803e3d6000fd5b505050506040513d602081101561167657600080fd5b5051156116c1576040805162461bcd60e51b815260206004820152601460248201527329b2b6331032bc31b63ab232b2103132ba3a32b960611b604482015290519081900360640190fd5b6006546040805163eae7d3d160e01b8152336004820152602481018690526044810185905290516001600160a01b039092169163eae7d3d19160648082019260009290919082900301818387803b158015610afc57600080fd5b60065460408051632f608c3360e11b81523360048201526024810184905290516001600160a01b0390921691635ec118669160448082019260009290919082900301818387803b1580156107ed57600080fd5b6000600460019054906101000a90046001600160a01b03166001600160a01b031663ddbb5cc66040518163ffffffff1660e01b815260040160206040518083038186803b1580156109af57600080fd5b60065460408051630f4edbf160e31b81523360048201526024810184905290516001600160a01b0390921691637a76df889160448082019260009290919082900301818387803b1580156107ed57600080fd5b6118196110ba565b611858576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b611861816119b6565b50565b60055460408051631c771c6960e21b815233600482015290516000926001600160a01b0316916371dc71a4916024808301926020929190829003018186803b1580156109af57600080fd5b6118b76110ba565b6118f6576040805162461bcd60e51b81526020600482018190526024820152600080516020611a6b833981519152604482015290519081900360640190fd5b6118fe6110ab565b6001600160a01b0316816001600160a01b0316141561195c576040805162461bcd60e51b81526020600482015260156024820152744f6e776572206d757374206e6f742062652043544f60581b604482015290519081900360640190fd5b600280546001600160a01b0319166001600160a01b03838116919091179182905560408051929091168252517f3278084dec868221e78ff53abc452308624a817c9513c85687d76c12ecb87873916020908290030190a150565b6001600160a01b0381166119fb5760405162461bcd60e51b8152600401808060200182810382526026815260200180611a456026913960400191505060405180910390fd5b600080546040516001600160a01b0380851693921691600080516020611a8b83398151915291a3600080546001600160a01b0319166001600160a01b039290921691909117905556fe4f776e61626c653a206e6577206f776e657220697320746865207a65726f20616464726573734f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65728be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0a265627a7a72305820529c625cf5fb24bbd7f745f1ef1c1106dcd1e73b882d4bbc4953c696461e88ca64736f6c634300050a0032";

    public static final String FUNC_REMOVEFROMWHITELIST = "removeFromWhiteList";

    public static final String FUNC_BETEXSETTINGS = "betexSettings";

    public static final String FUNC_GETCTO = "getCTO";

    public static final String FUNC_GETMARKETMANAGER = "getMarketManager";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_BETEXCORE = "betexCore";

    public static final String FUNC_BETEXSELFEXCLUDED = "betexSelfExcluded";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_SETMARKETMANAGER = "setMarketManager";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETCTO = "setCTO";

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

    public static final String FUNC_GETDEFAULTMAXAMOUNTWEIPERDAY = "getDefaultMaxAmountWeiPerDay";

    public static final String FUNC_GETDEFAULTMAXAMOUNTBTXPERDAY = "getDefaultMaxAmountBtxPerDay";

    public static final String FUNC_GETDEFAULTMAXBETSPERDAY = "getDefaultMaxBetsPerDay";

    public static final String FUNC_GETMINSTAKEWEI = "getMinStakeWei";

    public static final String FUNC_GETMAXSTAKEWEI = "getMaxStakeWei";

    public static final String FUNC_GETMINSTAKEBTX = "getMinStakeBtx";

    public static final String FUNC_GETMAXSTAKEBTX = "getMaxStakeBtx";

    public static final String FUNC_GETCOMISSIONWINNERBETWEI = "getComissionWinnerBetWei";

    public static final String FUNC_GETCOMISSIONCANCELBETWEI = "getComissionCancelBetWei";

    public static final String FUNC_GETCOMISSIONWINNERBETBTX = "getComissionWinnerBetBtx";

    public static final String FUNC_GETCOMISSIONCANCELBETBTX = "getComissionCancelBetBtx";

    public static final String FUNC_ISWINNER = "isWinner";

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
    protected BetexMobileGondwana(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BetexMobileGondwana(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BetexMobileGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BetexMobileGondwana(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> removeFromWhiteList(String _address) {
        final Function function = new Function(
                FUNC_REMOVEFROMWHITELIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> betexSettings() {
        final Function function = new Function(FUNC_BETEXSETTINGS, 
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

    public RemoteCall<String> betexCore() {
        final Function function = new Function(FUNC_BETEXCORE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> betexSelfExcluded() {
        final Function function = new Function(FUNC_BETEXSELFEXCLUDED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<Boolean> isWinner(BigInteger _betId) {
        final Function function = new Function(FUNC_ISWINNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_betId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> init(String _betexSettings, String _betexSelfExcluded, String _betexCore) {
        final Function function = new Function(
                FUNC_INIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_betexSettings), 
                new org.web3j.abi.datatypes.Address(_betexSelfExcluded), 
                new org.web3j.abi.datatypes.Address(_betexCore)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BetexMobileGondwana load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BetexMobileGondwana(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BetexMobileGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BetexMobileGondwana(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BetexMobileGondwana load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BetexMobileGondwana(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BetexMobileGondwana load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BetexMobileGondwana(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BetexMobileGondwana> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BetexMobileGondwana.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BetexMobileGondwana> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BetexMobileGondwana.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BetexMobileGondwana> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BetexMobileGondwana.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BetexMobileGondwana> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BetexMobileGondwana.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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
