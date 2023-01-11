#### GitHub使用笔记

[(参考内容)Github使用教程-黑马程序员]: https://www.bilibili.com/video/BV1st411r7Sj/?share_source=copy_web&amp;vd_source=5bf235313551b69ea95a3483fa733cc

##### 一. 基本概念&注册登录

###### 1.基本概念

**仓库Repository(即开源的项目)**

**收藏Star**

**复制克隆项目Fork**

**发起请求Pull Request**

B Fork A's Repository and modify it to modifyRepository. 

B Pull Request A modifyRepository.

A feel the modifyRepository is good and modify Repository to modifyRepository.(代码合并)

**关注Watch(更新后有通知)**

**事务卡片Issue(发现Bug,发起讨论,寻找解决方案)**

**GitHub主页**

**仓库主页**

**个人主页**

###### 2.注册登录

用户名,邮箱(重要,需要接收邮件),密码

qq邮箱域名白名单设置: 设置-反垃圾-白名单-设置域名白名单(github.com)

##### 二. 创建仓库&仓库主页

##### 三. 仓库管理

每一次修改都需要提交commit(修改的标题和详细说明),同时commit将会加1

###### 1.新建文件

Add file-Create new file-commit

###### 2.修改/编辑文件

双击文件名-Edit this file-commit

###### 3.删除文件

双击文件名-Delete this file-commit

###### 4.上传文件

Add file-Upload file-commit

###### 5.搜索仓库文件

Go to file

###### 6.下载/检出文件

Code

##### 四. GitHub Issues

###### 1.Issues

访问他人的Repository,发现Bug

Issues-New issues-commit

###### 2.Close issue

关闭issue权限在提出和被指出Bug的双方

##### 五. 实战GitHub基本概念

需要两个GitHub账号部分略

###### 1.删除代码仓库

仓库详情页-setting-下拉到最下方delete

##### 六. 安装Git

官网[Git for Windows](https://gitforwindows.org/)

镜像[CNPM Binaries Mirror (npmmirror.com)](https://registry.npmmirror.com/binary.html?path=git-for-windows/)

国内镜像网站下载exe文件,安装方式可百度

Git Bash Here命令行模式

Git GUI Here图形界面

Use Git from Windows Command Prompt选项二兼容选项一

桌面空白处右键出现快捷方式,说明安装成功

##### 七. Git基本工作流程

crtl+c复制，Shift+Ins(+Fn)粘贴

Git Repository(Git仓库,形成新版本,对他人可见)

暂存区(暂存文件,统一提交)

工作区(添加,编辑,修改文件等操作)

###### 1.查看状态

git status

###### 2.提交到暂存区

git status

git add 文件名.后缀名

###### 3.提交到仓库

git status

git commit -m "提交描述"

##### 八. Git初始化&仓库创建和操作

本地操作,不会影响网页仓库,具体见Git管理远程仓库

###### 1.基本信息设置

**用户名**

git config --global user.name "xxxx"

**用户名邮箱**

git config --global user.email"xxxx@qq.com"

**查看设置**

git config --list

**清屏**

clear

###### 2.初始化一个新的Git仓库

**新建文件夹**

mkdir 文件夹名称

**新建文件**

touch 文件名.后缀名

**查看当前文件夹文件**

ls

**查看当前文件夹路径**

pwd

**创建Git仓库/初始化Git**

cd 路径

git init

###### 3.向仓库添加文件

git add 文件名.后缀名(暂存区添加)

git status

git commit -m "描述"(GitHub仓库添加)

git status

###### 4.修改仓库文件

**本地编辑文件**

vi 文件名.后缀名

Esc退出编辑模式

ZZ退出编辑文件/:wq(强制退出编辑文件,注意冒号':')

随后可以向仓库添加文件

**查看文件内容**

cat 文件名.后缀名

**5.删除仓库文件**

rm -rf 文件名.后缀名(本地删除)

git rm 文件名.后缀名(暂存区删除)

git commit -m "描述"(GitHub仓库删除)

git status

##### 九. Git管理远程仓库

###### 1.Branch分支操作(一个分支对应一个版本)

切换分支 

git checkout master

在现有分支基础上创建新分支

 git checkout -b branch1

删除分支 

git branch -d branch1(删除本地分支)

git push origin -d 远程分支(删除远程分支)

查看分支

- git branch 列出本地已经存在的分支，并且当前分支会用*标记

- git branch -r 查看远程版本库的分支列表

- git branch -a 查看所有分支列表（包括本地和远程，remotes/开头的表示远程分支）

拉取远程分支 

- git pull origin 远程分支名称:本地分支名称

- 如果不写本地分支名称，则默认和远程分支同名(git pull origin 远程分支名称)

将新分支推送到远程仓库

- git push --set-upstream origin master
- 本地创建了一个名为master的分支,远程仓库还没有这个分支,将被创建

合并分支

[(3条消息) Git详细教程（五）：查看分支、创建分支、合并分支_幕尘枫的博客-CSDN博客_git 查看分支](https://blog.csdn.net/qq15577969/article/details/107632375)

查看远程仓库地址

git remote -v

**注意**:

- 执行 git init 的时候，默认情况下 Git 就会为你创建 master 分支

- GitHub默认有main分支,Git默认为master分支,,建议在GitHub-setting-branches中将main修改为master

###### 2.git克隆仓库

git clone 仓库地址

###### 3.将本地仓库同步到git远程仓库

**步骤1: 创建远程仓库**

在GitHub中创建远程仓库,将main分支改为master分支

将远程仓库克隆到本地,会自动生成.git目录及配置

```
git clone https://...
```

**步骤2: 生成令牌**

在 GitHub 上生成令牌,用于从本地push仓库到远程

注意: 

- 从 21 年 8 月 13 后不再支持用户名密码的方式验证了，需要创建个人访问令牌(personal access token)。特别注意网络教程/视频的发布时间
- 必须保存好令牌,退出页面后不可见

[(3条消息) 解决 remote Support for password authentication was removed on August 13, 2021._ASDDAG的博客-CSDN博客](https://blog.csdn.net/qq_50840738/article/details/125087816)

[(3条消息) Github创建个人访问令牌教程_这也太南了趴的博客-CSDN博客_gitlab个人访问令牌作用](https://blog.csdn.net/qq_46941656/article/details/119737804)

**步骤3:cd切换&右键Git**

切换到对应的仓库目录中,注意cd中路径中只能是"/",不能是"\"

右键进去Git Bush

**步骤4: 应用令牌**

```
git remote set-url origin https://<令牌>@github.com/<用户名>/<仓库名>.git
```

**步骤5: Git操作文件**

```
git add 文件
git commit -m "描述"
git push --set-upstream origin master
```

**步骤6: 提交用户名/密码**

将令牌号作为密码上传即可

###### 4.添加删除文件

```
// 添加文件
git add 文件名.后缀名
git commit -m "描述"
// 删除文件
rm -rf 文件名.后缀名
git rm 文件名.后缀名
git commit -m "描述"
```

##### Bug记录

###### Bug1

warning: in the working copy of 'xxx', LF will be replaced by CRLF the next time Git touches it

解决方法

```
git config core.autocrlf
```

##### 十. GitHub Pages搭建网站

###### 1.个人站点

访问(http://用户名.github.io)

搭建步骤

- 创建个人站点(新建仓库,仓库名必须是[用户名.github.io])
- 仓库下新建index.html文件即可

注意

- github pages只支持静态网页
- 仓库里面只能是.html文件

###### 2.项目站点

访问(http://用户名.github.io/仓库名)

搭建步骤

- 项目主页-setting
- Launch automatic page geerator生成主题页面
- 新建站点基础信息设置
- 选择主题
- 生成网页
