# rh-api

API Rest - sistema de administração de recursos humanos

Este projeto foi desenvolvido com spring-boot e mysql publicado no kubernetes atraves do plugin abric8 no maven.

Iniciar o mysql no kubernetes
    
    $ kubectl create -f deployment/mysql-deployment.yaml

Conectar no banco de dados

    $ kubectl run -it --rm --image=mysql:5.7 --restart=Never mysql-client -- mysql -h root -p marquesdba

Faca o build na aplicacao e o deploy no kubernetes

    $ mvn clean package

    $ mvn fabric8:build fabric8:resource fabric8:deploy

Test application :

    curl -X GET \
      http://127.0.0.1:8080/funcionarios \
      -H 'Accept: application/json' \
      -H 'Content-Type: application/json'
   
Resposta :

    []    

Para deletar os recursos do kubernetes como: deployment, service, secret and pvc.

    $ mvn fabric8:undeploy

    $ kubectl delete -f deployment/mysql-deployment.yaml

