#Editar ProFTPd /etc/proftpd/proftpd.conf
#usuarios bloqueados são /etc/ftpusers

sudo apt-get install proftpd

service proftpd start
# service proftpd restart
# service proftpd stop
# service proftpd status

#Configurar porta 
Port 2121

#Limita o numero de clientes
MaxClients 3

#Para limitar o acesso dos usuários aos seus respectivos
#diretórios home utiliza-se a clausula DefaultRoot. Veja o
DefaultRoot ~


#Para abrir um FTP público, deve-se habilitar o contexto
#<Anonymous ~ftp> ... </Anonymous> ao final do arquivo de configuração.

<Anonymous ~ftp>
    User ftp
    Group nogroup
    UserAlias anonymous ftp
    DirFakeUser on ftp
    DirFakeGroup on ftp
    RequireValidShell off
    MaxClients 20 #Maximo clientes
    DisplayLogin welcome.msg
    DisplayFirstChdir .message
    <Directory *> #Determina o diretorio a ser compartilhado
        <Limit WRITE> #Downloads e uploads de arquivos
            DenyAll #Negado escruta de arquivos
        </Limit>
    </Directory>
    <Directory /home/ftp/upload/> #Determina o diretorio a ser compartilhado
        <Limit READ WRITE> #Leitura e escrita
            DenyAll #Nega Leitura e escrita
        </Limit>
        <Limit STOR> #apenas upload de arquivos sem possibilidade de criação e deleção de diretórios.
            AllowAll #Liberado
        </Limit>
    </Directory>
</Anonymous>

#Os usuários anônimos têm acesso apenas aos arquivos dentro da pasta /srv/ftp, 
#que é visto pelo cliente FTP como o diretório raiz do servidor.
#Os diretórios compartilhados para acesso anônimo também são
#sempre criados nesta pasta. Após criar estes diretórios é necessário ajustar as permissões:
sudo chown -R ftp.nogroup caminho_do_diretorio

#Para acessar o seu servidor, os clientes devem usar o login
#"anonymous" ou "ftp", usando um endereço de e-mail qualquer
#como senha. 

#Para verificar se os serviços estão funcionando corretamente:
#Acessar os serviços do servidor através do modo texto do
#cliente Linux:
#FTP:
sudo ftp ip_do_servidor
#SSH:
sudo sftp usuario@ip_do_servidor