# .gitignore失效

```text
git rm -r --cached .
git add .
git commit -m 'update .gitignore'
```

# 退回上一次的本地 提交记录

```textile
 git reset head~1
```

# 常用命令

```text
 ## 设置 git 提交的用户名和邮箱

 git config --global user.name ""
 git config --global user.email ""

 ## 查看 git 提交的用户名和邮箱

 git config user.name
 git config user.email
 
 ## 使用token push pull 但要注意 token会过期 注意设置时间
 git remote set-url [origin(远程仓库名称默认是 origin)] https://[token]@github.com/zyresurgence/actinium.git
 git remote push origin main
```

# github出现无法拉取的情况

## 修改本地hosts

1. 查询出github的ip地址 https://www.ipaddress.com/
2. 修改hosts
3. 拉取代码（可能会出现 443 OPENSSL问题 重复操作即可）
