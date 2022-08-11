select * from users where firstname='Ase';


select firstname, lastname, role from users where firstname='Ase';
-- joined users table with team table
select firstname, lastname, role, t.name,t.batch_number  from users u
                                                                  join team t on u.team_id = t.id where firstname='Ase';

--join users, team and campus tables
select firstname, lastname, role, t.name,t.batch_number, c.location
from users u join team t on u.team_id = t.id
             join campus c on u.campus_id=c.id
where firstname='Ase';

select firstname, lastname, role, t.name,t.batch_number, c.location
from users u join team t on u.team_id = t.id
             join campus c on u.campus_id=c.id
where u.email='sbirdbj@fc2.com';

select * from users;
