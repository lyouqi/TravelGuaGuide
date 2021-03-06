[![CSDN](https://img.shields.io/badge/CSDN-@xiaolongonly-blue.svg?style=flat)](http://blog.csdn.net/guoxiaolongonly)
[![PersonBlog](https://img.shields.io/badge/PersonBlog-@xiaolongonly-blue.svg?style=flat)](http://xiaolongonly.cn/)

# 界面效果如下

![启动页](https://raw.githubusercontent.com/guoxiaolongonly/TravelGuaGuide/master/screen/launcher.png)
![首页](https://raw.githubusercontent.com/guoxiaolongonly/TravelGuaGuide/master/screen/main.png)
![小伙伴](https://raw.githubusercontent.com/guoxiaolongonly/TravelGuaGuide/master/screen/animal.png)
![收藏](https://raw.githubusercontent.com/guoxiaolongonly/TravelGuaGuide/master/screen/collect.png)
![特产](https://raw.githubusercontent.com/guoxiaolongonly/TravelGuaGuide/master/screen/specialy.png)
![称号](https://raw.githubusercontent.com/guoxiaolongonly/TravelGuaGuide/master/screen/name.png)
	
    不要忘了我们的所有数据和界面都可以在github的json文件里面配置有需要的小伙伴自行拿去用吧!!
[fir下载地址](https://fir.im/qwgl)

# 设计意图

最近旅行青蛙很火，我自己也在玩，然后发现一个痛点是每次找小动物喜欢吃什么，每个道具的用途，都需要打开浏览器搜索。实在不能忍，感觉很痛，于是决心自己写一个APP攻略！！

# 需求分析

1.需要先对界面上的每个功能放一张图解，还有基本玩法操作！！


2.针对出现的每个道具的名称和用途做一个分类查看器，描述名称，用途等... 比如说商城道具和带回来的特产，收藏品，抽奖的奖品等...


3.如果单机版其实就这么考虑。后面觉得应该做一个动态数据的功能。（因为如果游戏有新版本更新了APP也得更新新版本，所以我想给APP一个接口，用来传输每次更新的数据。这样我们就不用每次发一个版本了。 very nice!!）


4.既然需要提供接口，就需要一个服务器了。这边其实是有多种考虑。
- bomb后端云，这种免费后端数据库可以一键式增删改查，这个可是上上之选。
- 写个页面，导入jsoup，动态爬数据，技术帝的不二选择，不过网页经常变感觉还是很蛋疼的。
- 哈哈哈哈哈哈，因为我比较懒，不想再去看文档，所以在github上面写了一个json文件，发现文件在github上的页面结构好像跟平时json请求的一样，试着做了一下请求。发现鸡然可以，那就用github来维护吧，反正博客都github上搭过了)


# 产品规划

	coding之前的一些其他细节，首现是需要什么样的页面，怎样才能长得好看。噗，自己写APP都要兼职PM.UI.UE。 心疼的抱住了自己。  
	
1.页面既定的规划就是提供一个首页，实现列表对每个模块做划分，
  - 入门操作，因为日版的APP很多东西还是看不懂的，做一个引导用户入门。
  - 商店道具和作用介绍
  - 收藏品介绍
  - 特产介绍
  - 称号介绍
  - 小动物喜欢吃什么
  - 进阶攻略 提供一些骨灰级玩家需要的信息。（比如收割草，给小动物喂食什么合适等等..）
  - 更新数据

2. 根据需求其实已经很明了了首页6个tab，
  - 入门和进阶
  - 小动物介绍
  - 商店道具介绍
  - 特产介绍
  - 称号介绍
  - 收藏品介绍
  - 另外配置一个侧拉的View用来展示作者介绍，和数据更新，2333，装逼用！！

# Then coding

主要是考虑动态配置问题，不同数据分配不同页面

1.首页一个列表用来展示所有模块

2.模块下面可能有子模块，根据类别启动子模块的Activity。

3.功能，不同功能展示的页面效果也不一样。gridView
  - 小动物，中图，中文字描述，点击查看详情gridView
  - 商店道具，中图，中文字描述，点击查看详情gridView
  - 特产，小图，小文字描述，点击查看详情gridView
  - 称号，中图，中文字描述，点击查看详情gridView
  - 收藏品，中图，中文字描述，点击查看详情gridView
  - 入门和进阶，子模块，实现做图右文字列表做选择gridView
  - 详情页大图大文字listView 图片+文字每个段落
  - 预留一个webActivity做web加载。 预留一个TextActivity做文本加载

4.两种类型的模块选择页  ModularGridViewActivity,ModularListViewActivity.

5.三种详情查看页 BigPicDetailActivity,WebActivity,TextActivity

6.两种描述页 MiddleDecribeActivity,SmallDeScribeActivity

7.侧拉菜单

8.关于APP

最近太忙了，没时间写这个，今天花了一天时间把它全部做完了，功能设计什么的都不难，就是界面和一些交互体验，还有素材整理花了点时间。最终实现的结果可能跟之前预想的不太一样。

谈一谈不一样的地方
小动物，商店道具，特产，称号，收藏品，入门和进阶的页面，我写到了一个页面中。
原本预想其实就是分成好几个Activity来写，但是后来想想写了那么多Activity其实参数都一样，逻辑也都一样，就是页面的布局不一样而已。
写那么多的Activity其实可以写成一个Activity，然后Adapter做抽象，实现不同的 Adapter来实现不同的列表。
后面又想了一下，Adapter其实也不用做什么操作，只有布局不一样，点击响应和数据传递都是一样的。就把布局直接传给了Adapter。由数据来确定初始化什么布局，和布局的样式。
最终实现就是这样，但是也看出了这样实现的一些弊端，就是不适合数据量大的场景。不过我们的数据量确实不大，就先这样了！！nice day!!

---

就写到这里了。攻略也不想整理了！！！！  因为根本就找不到用户 2333！！

# License

```
Copyright 2018 Xiaolong 

```
