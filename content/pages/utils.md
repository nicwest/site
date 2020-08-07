---
title: Utils
url: /utils/
---

Collection of useful command line stuff

### Pod that crashes

Useful for testing monitoring tools like graphana

{{< highlight bash >}}
kubectl run crash-test-dummy --image=bash --command -- bash -c "sleep 30; exit 1"
{{</ highlight >}}

### Telnet but for secure connections

{{< highlight bash >}}
openssl s_client -connect nic-west.com:443
{{</ highlight >}}


### Show priority of all pods in kubernetes cluster

{{< highlight bash >}}
kubectl get pods -o custom-columns=NAME:.metadata.name,NAMESPACE:.metadata.namespace,PRIORITY:.spec.priority,PRIORITY_CLASS_NAME:.spec.priorityClassName -A
{{</ highlight >}}
