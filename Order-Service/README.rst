## How to Run the Project

1.Build the maven project by issuing following command in the project directory

``mvn clean install``

2.Build the docker image as follows

``docker build -t {docker registry address}/orderms``

Replace the {docker registry address} with the docker registry address image going to be uploaded.
If the Docker Hub is the registry replace it  with the Docker Hub username.

3.Update the docker image name({docker registry address}/orderms) in following [file](container/k8s/k8s-controller.yaml)

```yaml

apiVersion: v1
kind: ReplicationController
metadata:
  name: order
  labels:
    name: order
spec:
  replicas: 2
  selector:
    name: order
  template:
    metadata:
      labels:
        name: order
    spec:
      containers:
      - name: order
        image: ajanthan/order-ms
        env:
        - name: GET_HOSTS_FROM
          value: dns
          # If your cluster config does not include a dns service, then to
          # instead access environment variables to find service host
          # info, comment out the 'value: dns' line above, and uncomment the
          # line below.
          # value: env
        ports:
        - containerPort: 9092
```

4.Deploy the service in k8s

`kubectl apply -f container/k8s/`