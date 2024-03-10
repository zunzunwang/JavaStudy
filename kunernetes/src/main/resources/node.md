node之中包含
kubelet
kube_proxy
pod: container -> docker容器引擎
kubelet会通过 CRI：container runtime interface 对 docker进行操作 来维持pod的生命周期
 