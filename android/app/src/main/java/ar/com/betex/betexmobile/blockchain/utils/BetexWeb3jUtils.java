package ar.com.betex.betexmobile.blockchain.utils;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import ar.com.betex.betexmobile.entities.Configuration;
import ar.com.betex.betexmobile.entities.ConfigurationRinkeby;

/**
 * Utilidades para comunicarse con Ethereum
 */
public class BetexWeb3jUtils {
    public static final BigInteger TOKEN_PRECISION = BigInteger.TEN.pow(18);
    /**
     * Crea una instancia de web3 con utilizando una configuración determinada
     * @param configuration
     * @return web3
     */
    public static Web3j buildEthereumConnection(Configuration configuration) {
        Web3j web3 = Web3j.build(new HttpService(configuration.getEthereumEndPoint()));
        return web3;
    }


    /**
     * Transforma un gran número decimal a la precisión en tokens. Si después de transformar
     * aún tieen digitos enteros, solo devuelve la parte entera y los decimales los descarta
     * @param input
     * @return bigInteger
     */
    public static BigInteger toTokenPrecision(BigDecimal input) {
        if (input == null){
            return BigInteger.ZERO;
        }

        BigDecimal result = input.multiply(new BigDecimal(TOKEN_PRECISION));
        return result.toBigInteger();
    }

    public static BigDecimal fromTokenPrecision(BigInteger input) {
        if (input == null){
            return BigDecimal.ZERO;
        }

        BigDecimal result = new BigDecimal(input);
        result = result.divide(new BigDecimal(TOKEN_PRECISION));
        return result;
    }
    /**
     * Obtiene la versión del cliente
     * @param web3j
     * @return clientVersion
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static String getClientVersion(Web3j web3j) throws InterruptedException, ExecutionException {
        Web3ClientVersion client = web3j
                .web3ClientVersion()
                .sendAsync()
                .get();

        return client.getWeb3ClientVersion();
    }

    /**
     * Obtiene el coinbase
     * @param web3j
     * @return coinbase
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static EthCoinbase getCoinbase(Web3j web3j) throws InterruptedException, ExecutionException {
        return web3j
                .ethCoinbase()
                .sendAsync()
                .get();
    }

    /**
     * Obtiene la lista de cuentas del cliente
     * @param web3j
     * @return ethAccount
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static EthAccounts getAccounts(Web3j web3j) throws InterruptedException, ExecutionException {
        return web3j
                .ethAccounts()
                .sendAsync()
                .get();
    }

    /**
     * Obtiene el balance de una dirección determinada
     * @param web3j
     * @param address
     * @return balance
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static BigInteger getBalanceWei(Web3j web3j, String address) throws InterruptedException, ExecutionException {
        EthGetBalance balance = web3j
                .ethGetBalance(address, DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();

        return balance.getBalance();
    }

    /**
     * Obtiene el nonce (tx count) de una dirección especificada
     * @param web3j
     * @param address
     * @return txCount
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static BigInteger getNonce(Web3j web3j, String address) throws InterruptedException, ExecutionException {
        EthGetTransactionCount ethGetTransactionCount =
                web3j.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();

        return ethGetTransactionCount.getTransactionCount();
    }

    /**
     * Convierte un valor de wei a ether
     * @param wei
     * @return
     */
    public static BigDecimal weiToEther(BigInteger wei) {
        return Convert.fromWei(wei.toString(), Convert.Unit.ETHER);
    }

    public static BigDecimal toWei(BigDecimal ether) {
        return Convert.toWei(ether.toString(), Convert.Unit.ETHER);
    }
    /**
     * Returns the TransactionRecipt for the specified tx hash as an optional.
     */
    /**
     * Devuelve el TransactionReceipt de un hash de una tx como un optional
     * @param web3j
     * @param transactionHash
     * @return transactionReceipt
     * @throws Exception
     */
    public static TransactionReceipt getTransactionReceipt(Web3j web3j, String transactionHash) throws Exception
    {
        EthGetTransactionReceipt receipt = web3j
                .ethGetTransactionReceipt(transactionHash)
                .sendAsync()
                .get();

        return receipt.getTransactionReceipt().get();
    }



}
