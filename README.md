# cl_codebase

1.先把6.7压缩包(不要解压)HYBRISCOMM6700P_0-80003492.ZIP文件放到/cltop（项目名）目录下 在当前目录下执行 ant install

2.在 /cltop/hybris/bin/platform 下执行 ant clean all 没有报错后执行初始化 ant initialize，成功后可以启动服务./hybrisserver.sh 

3.URL访问可以参考config目录下的local.properties文件