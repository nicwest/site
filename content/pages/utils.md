---
title: Utils
url: /utils/
---

Collection of useful command line stuff

### Pod that crashes

Useful for testing monitoring tools like graphana

```
kubectl run crash-test-dummy --image=bash --command -- bash -c "sleep 30; exit 1"
```

### Telnet but for secure connections

```
openssl s_client -connect nic-west.com:443
```
