# Bugs discovered in project mates' code

## 1. Not able to deal with duplicated ids
> E.g.  
> ***File input 1:***  
**"ID5"**,"BOS657505","CAD","SAVINGS","95538"  
**"ID5"**,"BOS66196","SGD","CURRENT","961629"  

> ***File input 2:***  
"ID5","BOS657505","CAD","SAVINGS","95538"  

> ***Compared output:***   
"ID5","BOS66196","SGD","CURRENT","961629"     

## 2. Not able to deal with entry with "," inside
> E.g.  
> ***File input 1:***  
"ID5","BOS657505","CAD","SAVINGS",**","**  
> ***Raise error***:  
`InvalidDataException`  
  
## 3. Compare all columns rather than the columns keyed in
> E.g.  
> ***Column input:***   
Customer ID#,Account No.,Currency,Type  
> ***Actual column in input files:***   
Customer ID#,Account No.,Currency,Type, **Balance**

> ***File input 1:***  
"Customer ID#","Account No.","Currency","Type","Balance"
"ID1","","USD","SAVINGS",**"962510"**
"ID3","BOS656613",**"USD"**,"CURRENT","595290"  
  
> ***File input 2:***   
"Customer ID#","Account No.","Currency","Type","Balance"
"ID1","","USD","SAVINGS",**"962518"**
"ID3","BOS656613",**"111"**,"CURRENT","595290"


> ***Compared output:***   
> *Balance column difference is also included*
"ID1","","USD","SAVINGS",**"962518"**
"ID3","BOS656613",**"111"**,"CURRENT","595290"
"ID1","","USD","SAVINGS","**962510"**
"ID3","BOS656613",**"USD"**,"CURRENT","595290"