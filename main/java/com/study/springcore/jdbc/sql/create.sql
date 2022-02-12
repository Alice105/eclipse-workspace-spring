--建立Emp資料表
create table if not exists emp(
	eid int not null auto_increment,--主鍵(自動產生序號:1,2,3過號部返回)
	ename varchar(50) not null unique,--員工姓名
	age int,--員工年齡
	createtime timestamp default current_timestamp,--建檔時間
	primary key(eid)
	)
	
--建立Job資料表
create table if not exists job(
	jid int not null auto_increment,--主鍵(自動產生序號:1,2,3過號部返回)
	jname varchar(50) not null unique,--工作名稱
	eid int,--員工ID
	primary key(jid),
	foreign key(eid) references emp(eid)--外鍵約束/關聯
	)
--由上述可知，一個emp對應多個job，一個job對應多個emp
	
--每一個員工的工作列表
select e.ename ,j.jname 
from emp e,job j
where e.eid =j.eid 
order by e.ename 

--每一個員工有幾項工作
SELECT a.ename, count(b.jname)
FROM emp a inner JOIN job b on a.eid=b.eid
GROUP BY  a.ename

select e.ename, count(j.jname)
from emp as e, job as j
where e.eid = j.eid
group by e.ename

select e.ename , count(j.jid) as "工作數量"
from emp e 
left join job j
on e.eid = j.eid 
group by e.ename

select e.ename, count(j.jname) as work 
from emp e, job j
where e.eid=j.eid 
group by e.ename
order by 1

--查詢工作量最多的員工
select e.ename, count(j.jname) as work 
from emp e, job j
where e.eid=j.eid 
group by e.ename
order by 2 desc
limit 1



select e.eid,e.ename,e.age,e.createtime ,
		j.jid as job_jid,j.jname as job_jname,j.eid as job_eid
from emp e left outer join job j on j.eid=e.eid