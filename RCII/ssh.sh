sudo apt-get install openssh-server #instala o serviço

sudo service ssh start #inicia o serviço

sudo echo "# Define a porta de execução do servidor
Port 22
# Timeout da conexão SSH
LoginGraceTime 120
# Habilita o usuário administrador para fazer login
PermitRootLogin no
# Desabilita autenticação sem senha
PermitEmptyPasswords no

# Para restringir os usuários com acesso ao serviço:
AllowUsers joao maria" > /etc/ssh/sshd_config

sudo service ssh restart #reinicia o serviço

#status do serviço - service ssh status 

#para o serviço - service ssh stop

#Arquivo de configuração /etc/ssh/sshd_config
#Editar aqruivo nano /etc/ssh/sshd_config

sudo ssh 192.168.10.254 #solicia acesso a um servidor

#Também pode ser
# ssh usuario@ip_do_servidor
# ssh aluno@192.168.10.254

# para mudar a porta no arquivo etc/ssh/sshd_config
# Port 22

#Após o reiniciar o serviço e efetivar essas alterações será
#necessário informar a nova porta de comunicação quando
#quisermos nos conectar ao servidor através de um cliente SSH.
#No terminal o comando ficaria assim:
sudo ssh joao@192.168.1.10 –p 444 

#alterar os dados no cliente

#PermitRootLogin (yes/no) acesso do usuario root 
#PermitEmptyPasswords (yes/no) Para inibir a autenticação utilizando senhas em branco pode-se configurar o parâmetro:

#AllowUsers fulano ciclano

#DenyUsers root


#Exemplo de config

## Define a porta de execução do servidor
#Port 22
## Timeout da conexão SSH
#LoginGraceTime 120
## Habilita o usuário administrador para fazer login
#PermitRootLogin no
## Desabilita autenticação sem senha
#PermitEmptyPasswords no

## Para restringir os usuários com acesso ao serviço:
#AllowUsers joao maria