sudo apt-get install isc-dhcp-server

# Se der mensagem de erro é porque falta configuração

sudo service isc-dhcp-server start
#sudo service isc-dhcp-server restart
#sudo service isc-dhcp-server stop
#sudo service isc-dhcp-server status

# Arquivo de configuração é /etc/dhcp/dhcpd.conf

#Exemplo de configuração
sudo echo "
ddns-update-style none; #Determina se o servidor DNS deverá ser consultado ao realizar-se uma concessão de IP. O padrão é none.
default-lease-time 600; #controla o período e renovação da concessão de endereços em segundos.
max-lease-time 7200; #determina o tempo máximo que uma estação pode usarum determinado endereço IP. 
authoritative; #Configura o servidor como autoritário ou seja capaz de realizar a concessão de endereços IP.
subnet 192.168.10.0 netmask 255.255.255.0 #inicia um bloco de comandos indicando o endereço e mascara da rede que o servidor irá controlar:
{
    range 192.168.10.100 192.168.10.200; # determina a faixa de endereços IP que será usada pelo servidor. 
    option routers 192.168.10.254; # indica o endereço do default gateway da rede
    option broadcast-address 192.168.10.255; #Configura o endereço de broadcast da rede. 
    option domain-name-servers 192.168.10.254; #indica os servidores DNS da rede. 
    # option domain-name nome;# atribui nome do domínio. 
}" > /etc/dhcp/dhcpd.conf

sudo service isc-dhcp-server restart #Reinicia serviço

#IP FIXO PARA MAQUINA BASEADO NO ENDEREÇO MAC
sudo echo "
host pc01 {
    hardware ethernet 00:0F:B0:55:EA:13;
    fixed-address 192.168.10.198;
}
" >> /etc/dhcp/dhcpd.conf

#Para realizar este ajuste da configuração de interface basta editar o arquivo: /etc/default/isc-dhcp-server
# INTERFACES="eth1" #o servidor responderá apenas as solicitações enviadas por meio da interface indicada (eth1). 

#Soliciar endereços atribuidos pelo servidor DHCP
#Cliente Linux:
sudo ifconfig <interface_de_rede>
#Clientes Windows:
# ipconfig /all

#Para atualizar os endereços
#Cliente Linux:
sudo dhclient
#Clientes Windows:
#ipconfig /release
#ipconfig /renew

#CLIENTE
#As concessões realizada pelo servidor DHCP são armazenadas no arquivo /var/lib/dhcp3/dhcpd.leases. 