//  main.c
//  EDA2P3E1
//  Created by Monserrat Lopez on 29/09/21.
//listo
#include <stdio.h>
#include "ordenamientos2.h"
#include "utilidades2.h"
#include "Cola.h"
struct Cola{
    int primero;
    int ultimo;
    int lista[100];
};
void descomponer(int num,int Descomp[]){
    int div = 1000;
    for(int i = 0; i<4;i++){
        Descomp[i]=num/div;
        num = num%div;
        div=div/10;
    }
}
void LlenaQueues(int  descomposicion[],int index, int list[],SizeList,Cola Cola1,Cola Cola2,Cola Cola3,Cola Cola4){
    
    for (int i= 0; i<SizeList;i++){
        descomponer(list[i],descomposicion);
        //printArray(descomposicion,4);
        if (descomposicion[index] == 1 ){
           // printf("%d == 1\n",descomposicion[index]);
            encolarFinal(&Cola1,list[i]);
            
        }
        if (descomposicion[index] == 2 ){
            //printf("%d == 2\n",descomposicion[index]);
            encolarFinal(&Cola2,list[i]);
            
        }
        if (descomposicion[index] == 3 ){
           // printf("%d == 3\n",descomposicion[index]);
            encolarFinal(&Cola3,list[i]);
            
        }
        if (descomposicion[index] == 4 ){
           // printf("%d == 4\n",descomposicion[index]);
            encolarFinal(&Cola4,list[i]);
            
        }
    }
       /* printf("Cola 1\n");
        mostrarValores(Cola1);
        printf("Cola 2\n");
        mostrarValores(Cola2);
        printf("Cola 3\n");
        mostrarValores(Cola3);
        printf("Cola 4\n");
        mostrarValores(Cola4);*/
       
    int x=0;
    while (isEmpty(Cola1)!=1){
        list[x] =desencolarInicio(&Cola1);
        x++;
        //printf("El valor de x es %d\n", x);
        }
    while (isEmpty(Cola2)!=1){
        list[x] =desencolarInicio(&Cola2);
        x++;
        //printf("El valor de x es %d\n", x);
    }
    while (isEmpty(Cola3)!=1){
        list[x] =desencolarInicio(&Cola3);
        x++;
        //printf("El valor de x es %d\n", x);

    }
    while (isEmpty(Cola4)!=1){
        list[x] =desencolarInicio(&Cola4);
        x++;
        //printf("El valor de x es %d\n", x);
    }
    //printf("El valor de x es %d\n", x);
}
int main()
{
    int op = 0;
    int descomposicion[4]= {0,0,0,0};
    char *ptrDescomp;
    
    ptrDescomp = descomposicion;
    int list[15] ={1321,2111,1112,2214,3223,1232,1231,2221,1322,1412,3132,4241,1243,4121,4111};
    int *ptrList;
    ptrList = list;
   
    int SizeList = 15;
    printf("Que programa quieres usar?\n1)CountingSort\n2)RadixSort\n");
    scanf("%d",&op);
    switch (op) {
            
        case 1:
            {
                printf("CountingSort\n");
                CountingSort();
            }
            break;
        case 2:
            {
                printf("RadixSort\n");
                //PEDIR DATOS

                printf("Valores a ordenar(15-20):\n");
                scanf("%d",&op);
                printf("(Solo numeros de 4 digitos [1-4]):\n");
                for (int i = 0;i<op;i++){
                    printf("%d:",i+1);
                    scanf("%d",&list[i]);
                }
                printf("Tu arreglo orinal es es:\n");
                printArray(list,SizeList);
                Cola Cola1,Cola2,Cola3,Cola4;
                Cola1 = crearCola(10);
                Cola2 = crearCola(10);
                Cola3 = crearCola(10);
                Cola4 = crearCola(10);
                printf("Ordenando...\n");
                for (int i = 3; i>=0; i--){
                    LlenaQueues(ptrDescomp,i, ptrList,SizeList,Cola1,Cola2,Cola3,Cola4);
                    printArray(list,SizeList);
                }
                printf("Lista Ordenada:\n");
                printArray(list,SizeList);
               
            }
            break;
       
    }
    return 0;
}
