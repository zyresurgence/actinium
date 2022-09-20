# JWT

## JWT应用场景

1. 认证 Authentication；
2. 授权 Authorization;
3. 联合识别；
4. 客户端会话（无状态的会话）;
5. 客户端机密;

## JWT名字解释

1. **JWS** : Signed JWT签名过的jwt;

2. **JWE** : Encrypted JWT部分payload经过加密的jwt;

3. **JWK** : JWT的秘钥,即 secret;

4. **JWKset**: JWT key set 在非对称加密中，需要的是秘钥对而非单独的秘钥;

5. **JWA** : 当前JWT锁用到的密码学算法;

6. **nonsecure JWT** : 当头部的签名算法被设定为none的时候,该JWT是不安全的;因为签名的部分空缺,所有人都可以修改；

## JWT结构

```java
// 简单的jwt结构如下
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.
TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ
```

## JWT的组成

1. **header** : 主要声明了JWT的签名算法;

2. **payload** : 主要承载了各种声明并传递明文数据;

3. **signture** : 拥有该部分的JWT被称为JWS,也就是签名的JWS;没有该部分的JWT被称为nonsecure JWT 也就是不安全的JWT,此时header中声明的签名算法为none;

### JWT header

1. **typ** : 令牌类型 通常为 JWT;

2. **alg** : 算法类型,例如: HMAC SHA256或RSA;

3. **jti** : JWT ID,代表了正在使用的JWT的编号,这个该编号在对应服务端应当唯一。也可以放到payload中;

4. **cty** : content type, 当payload为任意数据的时候，这个头无需设置，但是当内容也带有jwt的时候（嵌套jwt）,这个值必须设定为jwt;

### JWT payload

1. **iss** : **issuer** 发布者的url地址;
2. **sub** : **subject** 该JWT所面向的用户，用于处理特定应用，不是常用的字段;
3. **aud** : **audience** 接受者的url地址;
4. **exp** : **expiration** 该jwt销毁的时间; unix时间戳；
5. **nbf** : **not before** 该jwt的使用时间不能早于改时间; unix时间戳;
6. **iat** : **issued at** 该jwt的发布时间; unix时间戳;
7. **jti** : **JWT ID** 该jwt的唯一ID编号;

[更多Public Claims 详情参考 IANA JSON Web Token Registry](https://www.iana.org/assignments/jwt/jwt.xhtml)

所以在JWT中,不应该在载荷里面加入任何敏感的数据（如密码），除非加密payload;

### JWT的工作原理

#### 认证流程

1. 前端通过Web表单将自己的用户名和密码发送到后端的接口。该过程一般是HTTP的POST请求。建议的方式是通过SSL加密的传输(https协议)，从而避免敏感信息被嗅探。

2. 后端核对用户名和密码成功后，将用户的id等其他信息作为JWT Payload(负载)，将其与头部分别进行Base64编码拼接后签名，形成一个JWT(Token)。

3. 后端将JWT字符串作为登录成功的返回结果返回给前端。前端可以将返回的结果保存在localStorage（浏览器本地缓存）或sessionStorage（session缓存）上，退出登录时前端删除保存的JWT即可。

4. 前端在每次请求时将JWT放入HTTP的Header中的Authorization位。(解决XSS和XSRF问题）HEADER

5. 后端检查是否存在，如存在验证JWT的有效性。例如，检查签名是否正确﹔检查Token是否过期;检查Token的接收方是否是自己(可选）

6. 验证通过后后端使用JWT中包含的用户信息进行其他逻辑操作，返回相应结果。

# JWS

## JWS 结构

JWT Signature, 在nonsecure JWT的基础上，在 头部声明签名算法,并在最后添加上签名。创建签名，是保证jwt不能被他人随意篡改。

## jwt signature 的签名算法

目前已知的签名算法有三种

1. 对称加密HMAC(哈希消息验证码): HS256/HS384/HS512;

2. 非对称加密RSASSA(RSA签名算法): RS256/RS384/RS512;

3. ECDSA(椭圆曲线数据签名算法): ES256/ES384/ES512;

```java
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6IjRmMWcyM2ExMmFhIn0.
eyJpc3MiOiJodHRwOi8vc2hhb2Jhb2Jhb2VyLmNuIiwiYXVkIjoiaHR0cDovL3NoYW9iYW9iYW9lci5jbi93ZWJ0ZXN0L2p3dF9hdXRoLyIsImp0aSI6IjRmMWcyM2ExMmFhIiwiaWF0IjoxNTM0MDcwNTQ3LCJuYmYiOjE1MzQwNzA2MDcsImV4cCI6MTUzNDA3NDE0NywidWlkIjoxLCJkYXRhIjp7InVuYW1lIjoic2hhb2JhbyIsInVFbWFpbCI6InNoYW9iYW9iYW9lckAxMjYuY29tIiwidUlEIjoiMHhBMCIsInVHcm91cCI6Imd1ZXN0In19.
GQPGEpixjPZSZ7CmqXB-KIGNzNl4Y86d3XOaRsfiXmQ
```

当验证签名的时候，利用公钥或者密钥来解密signature，和header以及payload中内容一致则表示通过。

## JWS的额外头部声明

为了确保服务器的密钥对可靠有效，同时也方便第三方CA机构来签署JWT而非本机服务的JWT，对于JWS的头部可以有额外的声明，具体取决于JWS的使用方式。

1. **jku**: 发送给JWK的地址，最要用HTTPS传输；

2. **jwk**: JWT的秘钥,即 secret;

3. **kid**: jwk的ID编号;

4. **x5u**: 指向一组X509公共证书的URL；

5. **x5c**: X509证书链；

6. **x5t**: X509证书的SHA-1指纹；

7. **x5t#S256**: X509证书的SHA-256指纹；

8. **typ**: 在原本未加密的JWT的基础上增加了JOSE和JOSE+JSON。适用于JOSE表头的对象与此JWT混合的情况；

9. **crit**: 字符串数组，包涵声明的名称，用作实现定义的扩展，必须由this->JWT的解析器处理。并不常见；

https://blog.csdn.net/Top_L398/article/details/109361680
https://blog.csdn.net/m0_49051691/article/details/109494815

## 多重验证与JWS序列化

当需要多重签名或者JOSE表头的对象与JWS混合的时候，就需要用到JWS的序列化，结构如下

```textile
{
    "payload": "eyJpc3MiOiJqb2UiLA0KICJleHAiOjEzMDA4MTkzODAsDQogImh0dHA6Ly9leGFtcGxlLmNvbS9pc19yb290Ijp0cnVlfQ",
"signatures": 
    [
        {
            "protected": "eyJhbGciOiJSUzI1NiJ9",
            "header": { "kid": "2010-12-29" },
            "signature":"signature1"
        },
        {
            "protected": "eyJhbGciOiJSUzI1NiJ9",
            "header": { "kid": "e9bc097a-ce51-4036-9562-d2ade882db0d" },
            "signature":"signature2"
        },
        ...
    ]
}
```

1. **protected**: 之前的 头部声明，使用base64uri加密；

2. **header**: JWS的额外声明，该内容不会放在签名中，无需验证；

3. **signature**: 当前的header+payload的签名；

# JWE

JSON Web Encryption,用于保护数据不被第三方的人看到，使用JWE会使JWT变得更加安全；

JWE和JWS的公钥私钥方案不同，JWS中，私钥持有者加密令牌，公钥持有者验证令牌。但是在JWE中，私钥一方是唯一可以解密令牌的一方。

在JWE中，公钥持有可以将新的数据放入JWT中，但是在JWS中，公钥持有者只能验证数据，不能引入新的数据，所以对于公钥和私钥的方案而言，JWS和JWE是互补的。

|          | JWS         | JWE         |
| -------- |:-----------:|:-----------:|
| producer | private_key | public_key  |
| consumer | public_key  | private_key |

## JWE的构成

```java
eyJhbGciOiJSU0ExXzUiLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.
UGhIOguC7IuEvf_NPVaXsGMoLOmwvc1GyqlIKOK1nN94nHPoltGRhWhw7Zx0-kFm1NJn8LE9XShH59_
i8J0PH5ZZyNfGy2xGdULU7sHNF6Gp2vPLgNZ__deLKxGHZ7PcHALUzoOegEI-8E66jX2E4zyJKxYxzZIItRzC5hlRirb6Y5Cl_p-ko3YvkkysZIFNPccxRU7qve1WYPxqbb2Yw8kZqa2rMWI5ng8Otv
zlV7elprCbuPhcCdZ6XDP0_F8rkXds2vE4X-ncOIM8hAYHHi29NX0mcKiRaD0-D-ljQTPcFPgwCp6X-nZZd9OHBv-B3oWh2TbqmScqXMR4gp_A.
AxY8DCtDaGlsbGljb3RoZQ.
KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY.
9hH0vgRfYgPnAHOd8stkvw
```

JWE一共分为五个部分

1. **The protected header**: 类似JWS的头部；

2. **The encrypted key**: 用于加密密文和其它加密数据的对称密钥；

3. **The initialization vector**: 初始IV值，有些加密方式需要额外的或随机的数据；

4. **The encrypted data (cipher text)**: 密文数据；

5. **The authentication tag**: 有算法产生的附加数据，用于防止密文呗篡改；

## JWE 秘钥加密算法

JWE需要对密钥进行加密，意味着同一个JWT中至少有两种加密算法在起作用，但是并非将密钥拿来就能用，我们需要对秘钥加密后，利用JWK秘钥管理模式来导出这些秘钥，JWK的管理模式分为五种

1. Key Encryption

2. Key Wrapping

3. Direct Key Agreement

4. Key Agreement With Key Wrapping

5. Direct Encryption

并不是所有的JWA都能够支持这五种秘钥管理模式，也并非每种秘钥管理模式之间都可以相互转换。可以参考（https://github.com/Spomky-Labs/jose/blob/master/doc/operation/Encrypt.md）

## JWE Header

JWE头部额外声明

1. **type**: 一般是jwt;

2. **alg**: 算法名称，和JWS相同，该算法用于加密稍后用于加密内容的实际密钥;

3. **enc**: 算法名称，用上一步生成的密钥加密内容的算法;

4. **zip**: 加密前压缩数据的算法，该参数可选，如果不存在则不执行压缩，通常的值为DEF，也就是deflate算法;

5. **jku/jkw/kid/x5u/x5c/x5t/x5t#S256/typ/cty/crit**: 和JWS额外声明相同;

## JWE加密过程

1. 根据头部alg的声明，生成一定大小的随机数；

2. 根据密钥管理模式确定加密密钥；

3. 根据密钥管理模式确定JWE加密密钥，得到CEK；

4. 计算初始IV，如果不需要，跳过此步骤；

5. 如果ZIP头申明了，则压缩明文；

6. 使用CEK，IV和附加认证数据，通过enc头声明的算法来加密内容，结果为加密数据和认证标记；

7. 压缩内容，返回token。

```java
 // Steps 1
 base64(header) 

 // Steps 2 and 3
 + '.' +base64(encryptedKey)

 // Step 4
 + '.' + base64(initializationVector)

 // Step 5
 + '.' + base64(ciphertext)

 // Step 6
 + '.' + base64(authenticationTag) 
```

## 多重验证与JWE序列化

```java
{
    "protected": "eyJlbmMiOiJBMTI4Q0JDLUhTMjU2In0",
    "unprotected": { "jku":"https://server.example.com/keys.jwks" },
    "recipients":[
        {
        "header": { "alg":"RSA1_5","kid":"2011-04-29" },
        "encrypted_key":
        "UGhIOguC7Iu...cqXMR4gp_A"
        },
        {
        "header": { "alg":"A128KW","kid":"7" },
        "encrypted_key": "6KB707dM9YTIgH...9locizkDTHzBC2IlrT1oOQ"
        }
    ],
    "iv": "AxY8DCtDaGlsbGljb3RoZQ",
    "ciphertext": "KDlTtXchhZTGufMYmOYGS4HffxPSUrfmqCHXaI9wOGY",
    "tag": "Mz-VPPyU4RlcuYv1IwIvzw"
}
```

1. **protected**：之前的头部声明，利用b64uri加密；

2. **unprotected**：一般放JWS的额外声明，这段内容不会被b64加密；

3. **iv**：64加密后的iv参数；

4. **add**：额外认证数据；

5. **ciphertext**：b64加密后的加密数据；

6. **recipients**：b64加密后的认证标志-加密链，这是一个数组，每个数组中包含了两个信息；

7. **header**：主要是声明当前密钥的算法；

8. **encrypted_key**：JWE加密密钥。
