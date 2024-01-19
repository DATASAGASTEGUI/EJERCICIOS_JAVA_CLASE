#!/bin/bash
:<<COMENTARIO
Autor: Walter Ismael Sagástegui Lescano
Fecha: 18/04/2023
Hora : 18:47
COMENTARIO

while true; do
#Mostramos el menú
clear
echo
echo "MENU" 
echo "----" 
echo "(1) CREAR UN CONTROL DE VERSION" 
echo "(2) CONFIGURAR USUARIO: NOMBRE-EMAIL-PASSWORD"
echo "(3) REALIZAR PRIMER COMMIT"
echo "(4) REALIZAR EL COMMIT SOBRE EL ULTIMO"
echo "(5) CONFIGURAR REPOSITORIO REMOTO"
echo "(6) CAMBIAR NOMBRE DE LA RAMA PRINCIPAL DE MASTER A MAIN"
echo "(7) SUBIR EL REPOSITORIO LOCAL AL REMOTO"
echo "(8) SALIR"

echo
echo -n "SELECCIONE UNA OPCION: "
read opcion

case $opcion in

1)
clear
echo "(1) CREAR UN CONTROL DE VERSION"
echo "-------------------------------"
git init
read -rsp $'\nPress enter to continue...'
;; 

2)
clear
echo "(2) CONFIGURAR USUARIO: NOMBRE-EMAIL-PASSWORD"
echo "---------------------------------------------"
git config user.name "DATASAGASTEGUI"
git config user.email "datasagamadrid@gmail.com"
git config user.password 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
read -rsp $'\nPress enter to continue...'
;; 

3)
clear
echo "(3) REALIZAR PRIMER COMMIT"
echo "--------------------------"
git add .
git commit -m "SNAPSHOT 1"
read -rsp $'\nPress enter to continue...'
;;

4)
clear
echo "(4) REALIZAR EL COMMIT SOBRE EL ULTIMO"
echo "--------------------------------------"
git add .
git commit --amend -m "SNAPSHOT 1"
read -rsp $'\nPress enter to continue...'
;;

5)
clear
echo "(5) CONFIGURAR REPOSITORIO REMOTO"
echo "---------------------------------"
git remote add origin "https://github.com/DATASAGASTEGUI/EJERCICIOS_JAVA_CLASE.git"
read -rsp $'\nPress enter to continue...'
;;

6)
clear
echo "(6) CAMBIAR NOMBRE DE LA RAMA PRINCIPAL DE MASTER A MAIN"
echo "--------------------------------------------------------" 
git branch -M main 
read -rsp $'\nPress enter to continue...'   
;;

7)
clear
echo "(7) SUBIR EL REPOSITORIO LOCAL AL REMOTO"
echo "----------------------------------------"   
git push -u -f origin master 
read -rsp $'Press enter to continue...' 
;;

8)
clear
echo "GRACIAS POR SU VISITA"
read -rsp $'\nPress enter to continue...'
exit 0
;;

*)
clear
echo "OPCION INCORRECTA\n"
read -rsp $'\nPress enter to continue...'
;;

esac
done


