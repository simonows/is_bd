var today_obj=new Date()
var today_date=today_obj.getDate()

var tips=new Array()
// "header" of the tip
var tiptitle='<img src="../../tip.gif"> <b>JavaScript Совет Дня</b><br />'

// Configure the below array to hold the 31 possible tips of the month
tips[1]='Tip 1 goes here'
tips[2]='Tip 2 goes here'
tips[3]='Tip 3 goes here'
tips[4]='Tip 4 goes here'
tips[5]='Tip 5 goes here'
tips[6]='Tip 6 goes here'
tips[7]='Tip 7 goes here'
tips[8]='Tip 8 goes here'
tips[9]='Tip 9 goes here'
tips[10]='Tip 10 goes here'
tips[11]='Tip 11 goes here'
tips[12]='Tip 12 goes here'
tips[13]='Tip 13 goes here'
tips[14]='Tip 14 goes here'
tips[15]='Tip 15 goes here'
tips[16]='Tip 16 goes here'
tips[17]='Tip 17 goes here'
tips[18]='Tip 18 goes here'
tips[19]='Tip 19 goes here'
tips[20]='Tip 20 goes here'
tips[21]='Tip 21 goes here'
tips[22]='Tip 22 goes here'
tips[23]='Tip 23 goes here'
tips[24]='Tip 24 goes here'
tips[25]='Tip 25 goes here'
tips[26]='Tip 26 goes here'
tips[27]='Tip 27 goes here'
tips[28]='Tip 28 goes here'
tips[29]='Tip 29 goes here'
tips[30]='Tip 30 goes here'
tips[31]='Tip 31 goes here'

document.write(tiptitle)
document.write(tips[today_date])

