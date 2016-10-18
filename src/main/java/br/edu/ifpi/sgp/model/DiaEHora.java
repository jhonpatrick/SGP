/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model;

/**
 *
 * @author Agustin
 */
public enum DiaEHora {
    SEG7H00("Segunda, 7h00 às 7h50"),
    SEG7H50("Segunda, 7H50 às 8h40"),
    SEG8H40("Segunda, 8h40 às 9h30"),
    SEG10H00("Segunda, 10h00 às 10h50"),
    SEG10H50("Segunda, 10h50 às 11h40"),
    SEG11H40("Segunda, 11h40 às 12h30"),
    SEG14H00("Segunda, 14h00 às 15h00"),
    SEG15H00("Segunda, 15h00 às 16h00"),
    SEG16H00("Segunda, 16h00 às 17h00"),
    SEG17H00("Segunda, 17h00 às 18h00"),
    SEG18H00("Segunda, 18h00 às 19h00"),
    SEG19H00("Segunda, 19h00 às 20h00"),
    SEG20H00("Segunda, 20h00 às 21h00"),
    SEG21H00("Segunda, 21h00 às 22h00"),
    TER7H00("Terça, 7h00 às 7h50"),
    TER7H50("Terça, 7H50 às 8h40"),
    TER8H40("Terça, 8h40 às 9h30"),
    TER10H00("Terça, 10h00 às 10h50"),
    TER10H50("Terça, 10h50 às 11h40"),
    TER11H40("Terça, 11h40 às 12h30"),
    TER14H00("Terça, 14h00 às 15h00"),
    TER15H00("Terça, 15h00 às 16h00"),
    TER16H00("Terça, 16h00 às 17h00"),
    TER17H00("Terça, 17h00 às 18h00"),
    TER18H00("Terça, 18h00 às 19h00"),
    TER19H00("Terça, 19h00 às 20h00"),
    TER20H00("Terça, 20h00 às 21h00"),
    TER21H00("Terça, 21h00 às 22h00"),
    QUA7H00("Quarta, 7h00 às 7h50"),
    QUA7H50("Quarta, 7H50 às 8h40"),
    QUA8H40("Quarta, 8h40 às 9h30"),
    QUA10H00("Quarta, 10h00 às 10h50"),
    QUA10H50("Quarta, 10h50 às 11h40"),
    QUA11H40("Quarta, 11h40 às 12h30"),
    QUA14H00("Quarta, 14h00 às 15h00"),
    QUA15H00("Quarta, 15h00 às 16h00"),
    QUA16H00("Quarta, 16h00 às 17h00"),
    QUA17H00("Quarta, 17h00 às 18h00"),
    QUA18H00("Quarta, 18h00 às 19h00"),
    QUA19H00("Quarta, 19h00 às 20h00"),
    QUA20H00("Quarta, 20h00 às 21h00"),
    QUA21H00("Quarta, 21h00 às 22h00"),
    QUI7H00("Quinta, 7h00 às 7h50"),
    QUI7H50("Quinta, 7H50 às 8h40"),
    QUI8H40("Quinta, 8h40 às 9h30"),
    QUI10H00("Quinta, 10h00 às 10h50"),
    QUI10H50("Quinta, 10h50 às 11h40"),
    QUI11H40("Quinta, 11h40 às 12h30"),
    QUI14H00("Quinta, 14h00 às 15h00"),
    QUI15H00("Quinta, 15h00 às 16h00"),
    QUI16H00("Quinta, 16h00 às 17h00"),
    QUI17H00("Quinta, 17h00 às 18h00"),
    QUI18H00("Quinta, 18h00 às 19h00"),
    QUI19H00("Quinta, 19h00 às 20h00"),
    QUI20H00("Quinta, 20h00 às 21h00"),
    QUI21H00("Quinta, 21h00 às 22h00"),
    SEX7H00("Sexta, 7h00 às 7h50"),
    SEX7H50("Sexta, 7H50 às 8h40"),
    SEX8H40("Sexta, 8h40 às 9h30"),
    SEX10H00("Sexta, 10h00 às 10h50"),
    SEX10H50("Sexta, 10h50 às 11h40"),
    SEX11H40("Sexta, 11h40 às 12h30"),
    SEX14H00("Sexta, 14h00 às 15h00"),
    SEX15H00("Sexta, 15h00 às 16h00"),
    SEX16H00("Sexta, 16h00 às 17h00"),
    SEX17H00("Sexta, 17h00 às 18h00"),
    SEX18H00("Sexta, 18h00 às 19h00"),
    SEX19H00("Sexta, 19h00 às 20h00"),
    SEX20H00("Sexta, 20h00 às 21h00"),
    SEX21H00("Sexta, 21h00 às 22h00"),
    SAB7H00("Sábado, 7h00 às 7h50"),
    SAB7H50("Sábado, 7H50 às 8h40"),
    SAB8H40("Sábado, 8h40 às 9h30"),
    SAB10H00("Sábado, 10h00 às 10h50"),
    SAB10H50("Sábado, 10h50 às 11h40"),
    SAB11H40("Sábado, 11h40 às 12h30"),
    SAB14H00("Sábado, 14h00 às 15h00"),
    SAB15H00("Sábado, 15h00 às 16h00"),
    SAB16H00("Sábado, 16h00 às 17h00"),
    SAB17H00("Sábado, 17h00 às 18h00"),
    SAB18H00("Sábado, 18h00 às 19h00"),
    SAB19H00("Sábado, 19h00 às 20h00"),
    SAB20H00("Sábado, 20h00 às 21h00"),
    SAB21H00("Sábado, 21h00 às 22h00");
    
    
    
    private final String  nomeBonito;
    
    private DiaEHora(String nomeBonito){
        this.nomeBonito = nomeBonito;
    }
    
    public String getNomeBonito(){
        return this.nomeBonito;
    }
}
