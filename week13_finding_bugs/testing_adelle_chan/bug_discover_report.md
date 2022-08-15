# Bugs discovered in project mates' code  

## 1. Not able to deal with null entry  
> E.g.  
> ***File 1:***   
"Customer ID#","Account No.","Currency","Type","Balance"  
"ID1","","USD","SAVINGS","962510"  
> ***Raise error***:  
`FileFormatException`

## 2. Not able to deal with duplicated ids
> E.g.  
> ***File input 1:***  
**"ID5"**,"BOS657505","CAD","SAVINGS","95538"  
**"ID5"**,"BOS66196","SGD","CURRENT","961629"  

> ***File input 2:***  
"ID5","BOS657505","CAD","SAVINGS","95538"  

> ***Compared output:***   
"ID5","BOS66196","SGD","CURRENT","961629"     

## 3. Not able to deal with entry with "," inside
> E.g.  
> ***File input 1:***  
"ID5","BOS657505","CAD","SAVINGS",**","**  
> ***Raise error***:  
`FileFormatException`  
  
## 4. Not able to switch columns
> E.g.  
> ***File 1:***   
"Customer ID#","Account No.","Type","Balance",**"Currency"**  
"ID1","BOS85009","SAVINGS","962510",**"USD"**  
...   
> ***Raise error***:  
`FileFormatException`  

## 5. Not able to output difference for id that exists in only one file
> E.g.  
> ***File 1:***   
"Customer ID#","Account No.","Currency","Type","Balance"  
"ID1","","USD","SAVINGS","962518"  
...
"ID6","BOS66196","SGD","CURRENT","961629"

> ***File 2:***   
"Customer ID#","Account No.","Currency","Type","Balance"  
"ID1","","USD","SAVINGS","962518"  
...
"ID6","BOS66196","SGD","CURRENT","961629"
**"ID7","BOS29226","SGD","CURRENT","962229"**

> ***Compared output:***   
`null` 






