-- Write your PostgreSQL query statement below


select ac.machine_id, round(avg(ac.timestamp - cac.timestamp)::numeric,3)as processing_time from Activity as ac
join (select machine_id, process_id, timestamp from Activity 
where activity_type = 'start') as cac 
on cac.process_id = ac.process_id and cac.machine_id=ac.machine_id
where ac.activity_type = 'end'
group by ac.machine_id
