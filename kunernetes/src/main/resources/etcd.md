etcd官方将它定位成一个
可信赖的
分布式 键值 存储服务
用于保存和管理分布式系统需要持续运行的关键信息 （运行的配置 在运行过程中各个节点的运行状态）
它能够为整个分布式集群存锤关键数据，协助分布式集群的正常运转。
etcd作为持久化方案
c/s结构： client/server 需要在每一个客户机安装客户端程序
b/s结构： browser/server
etcd存储 k8s的参数信息
raft共识算法
zookeeper vs etcd
zookeeper树形存储
etcd 键值对
 