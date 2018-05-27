# Spring Webflux + Docker + minikube + hyperkit
## Dependencies
```
brew cask install docker
brew cask install minikube
```

### Install Hyperkit Driver
```
curl -LO https://storage.googleapis.com/minikube/releases/latest/docker-machine-driver-hyperkit \
&& chmod +x docker-machine-driver-hyperkit \
&& sudo mv docker-machine-driver-hyperkit /usr/local/bin/ \
&& sudo chown root:wheel /usr/local/bin/docker-machine-driver-hyperkit \
&& sudo chmod u+s /usr/local/bin/docker-machine-driver-hyperkit
```

## Run minikube
```
minikube start --vm-driver=hyperkit
minikube dashboard
```

## Use minikube as a docker-machine
```
eval $(minikube docker-env)
```

## Enable ingress
```
minikube addons enable ingress
```

## Describe Ingress
```
kubectl describe ingress
```

## hotdog-api routes

- `/` (Returns `200`, empty body)
- `/hello` (Returns `200` with `hello` as text)