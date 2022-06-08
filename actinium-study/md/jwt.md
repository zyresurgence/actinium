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

# JWS

## JWS 结构

JWT Signature, 在nonsecure JWT的基础上，在 头部声明签名算法,并在最后添加上签名。创建签名，施暴者jwt不能被他人随意篡改。

## jwt signature 的签名算法

目前已知的签名算法有三种

1. 对称加密HMAC(哈希消息验证码): HS256/HS384/HS512;

2. 非对称加密RSASSA(RSA签名算法): RS256/RS384/RS512;

3. ECDSA(椭圆曲线数据签名算法): ES256/ES384/ES512;

当验证签名的时候，利用公钥或者密钥来解密signature，和header以及payload中内容一致则表示通过。

## JWS的额外头部声明

为了确保服务器的密钥对可靠有效，同时也方便第三方CA机构来签署JWT而非本机服务的JWT，对于JWS的头部可以有额外的声明，具体取决于JWS的使用方式。


