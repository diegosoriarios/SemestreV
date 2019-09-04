sudo apt-get install bind9

#Arquivos de configuração ficam no /etc/bind
#O arquivo /etc/bind/db.root, descreve os servidores raiz de todo mundo e não deve ser alterado. 

# O arquivo principal de configuração é /etc/bind/named.conf, este
#possui três includes para outros arquivos:

#named.conf.options: por padrão o BIND trabalha como servidor de cache, mas para que ele possa 
#efetuar consultas externamente é necessário incluir o IP do provedor de DNS ou um servidor válido;

#named.conf.local: arquivo que contém as configurações de zonas

#named.conf.default-zones: contém os arquivos padrões de zona. Geralmente este arquivo não é alterado

# Editar arquivo /etc/bind/named.conf.options
#forwarders {
#    8.8.8.8;
#};

#Adicionando uma zona disciplinarc2.com.br
# editar /etc/bind/named.conf.local

#zone "disciplinarc2.com.br" IN {
# type master;
# file "/etc/bind/db.disciplinarc2.com.br";
#};

#Para criar o arquivo /etc/bind/db.disciplinasrc2.com.br faça:
sudo cp /etc/bind/db.local /etc/bind/db.disciplinarc2.com.br

#Alterar
# localhost para hostname do servidor;
# 127.0.0.1 para ip do servidor;
# root.localhost para email de dominio

#Além disso crie uma entrar A para debian.disciplinarc2.com.br, o servidor de nomes neste caso?

#EXEMPLO
sudo echo "$TTL 604800
@ IN SOA debian.disciplinarc2.com.br. root.disciplinarc2.com.br. (
                                2015083101 ; Serial
                                604800 ; Refresh
                                86400 ; Retry
                                2419200 ; Expire
                                604800 ) ; Negative Cache TTL
;
@ IN NS debian.disciplinarc2.com.br.
@ IN A 192.168.10.254
debian IN A 192.168.10.254
www IN CNAME debian " > /etc/bind/db.disciplinarc2.com.br

# DNS resolver um endereço IP
#/etc/bind/named.conf.local 
#zone “10.168.192.in-addr.arpa” IN {
#    type master;
#    file "/etc/bind/db.192.168.10.rev";
#};

cp /etc/bind/db.127 /etc/bind/db.192.168.10.rev

#Após editar o arquivo /etc/bind/db.192.168.10.rev alterando
#basicamente as mesmas opções do arquivo
#/etc/bind/db.disciplinarc2.com.br, conforme exemplo a seguir:

sudo echo "$TTL 604800
@ IN SOA debian.disciplinarc2.com.br. root.disciplinarc2.com.br. (
                                    2015083101 ; Serial
                                    604800 ; Refresh
                                    86400 ; Retry
                                    2419200 ; Expire
                                    604800 ) ; Negative Cache TTL
;
@ IN NS debian.disciplinarc2.com.br.
254 IN PTR debian.disciplinarc2.com.br." > /etc/bind/db.192.168.10.rev

sudo service bind9 restart

#Verificar se tudo esta configurado corretamente
#named-checkzone <nomedazona> <arquivodazona>
named-checkzone disciplinarc2.com.br db.disciplinarc2.com.br

#Verificar se ocorreu um erro
tail -n 40 /var/log/syslog
#ou
# service bind9 status