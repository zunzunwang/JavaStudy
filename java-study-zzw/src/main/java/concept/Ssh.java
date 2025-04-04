package concept;

/**
 * Created by zunzunwang
 * Date: 28/07/2022
 */
public class Ssh {
    /**
     * Introduction SSH
     * SSH = Secure shell = Terminal Sécurisé
     *
     * histoire: telnet port 23
     * information connexion en claire
     *
     * SSH: information encrypted
     * port: 22
     *
     * password login:
     * on server side: public key + private key
     * 1. Client requests the connexion.
     * 2. server receives the request and return the public key.
     * 3. Client encrypts the password with pb key and send to server.
     * 4. server decrypts the encrypted password and do the authentication.
     *
     * disadvantages: Man-in-the-middle attack
     *
     * no password login:
     * preparation:
     * client generate the public key and private key
     * client sent the public key to server ($HOME/.ssh/authorized_keys).
     * (use ssh-keygen to generate the ssh key)
     *
     * 1. Client sent the request to server.
     * 2. server generate a random String
     * 3. server use the public key to encrypt the random String
     * 4. client use the private key to decrypt the encrypted String
     * 5. client sent the random string to server and at server compare the randString
     *
     * 对称加密算法使用同一个密钥对数据进行加密和解密。SSH连接建立过程中生成的会话密钥就是对称密钥，
     * 该对称密钥是由客户端和服务器端基于共享的部分信息和各自的私有数据使用密钥交换算法分别生成的。
     * 因为对称加密算法加解密的速度很快，所以适用于传输大量数据的场景。
     *
     *
     */
}
