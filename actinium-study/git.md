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
```