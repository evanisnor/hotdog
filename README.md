# Spring Webflux + Docker + minikube + hyperkit

## Setup
```
brew cask install docker
brew cask install minikube

# Install hyperkit driver
curl -LO https://storage.googleapis.com/minikube/releases/latest/docker-machine-driver-hyperkit \
&& chmod +x docker-machine-driver-hyperkit \
&& sudo mv docker-machine-driver-hyperkit /usr/local/bin/ \
&& sudo chown root:wheel /usr/local/bin/docker-machine-driver-hyperkit \
&& sudo chmod u+s /usr/local/bin/docker-machine-driver-hyperkit

minikube start --vm-driver=hyperkit

# If you want to see the kubernetes dashboard
minikube dashboard

# Use minikube as a docker-machine
eval $(minikube docker-env)

# Enable ingress
minikube addons enable ingress
```

## Build & deploy

```
./gradlew clean dockerBuildImage
./gradlew deploy

# Only need to run these if these configs have changed
kubectl apply -f hotdog-api/api.service.yaml
kubectl apply -f hotdog-api/api.ingress.yaml

# Describes the ingress and its backends
kubectl describe ingress
```

## Testing

- `/` (Returns `200`, empty body)
- `/hello` (Returns `200` with `hello` as text)

```
curl <ingress IP>/hello
> hello
```