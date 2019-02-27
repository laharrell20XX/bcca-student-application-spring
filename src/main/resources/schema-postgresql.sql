CREATE TABLE IF NOT EXISTS student_applications (
    id serial,
    name text,
    age int,
    phone_number text,
    email text,
    high_school text,
    graduation_date date,
    prior_knowledge text,
    current_plan text,
    aptitude text,
    dedication text,
    passion text
);

GRANT ALL PRIVILEGES ON student_applications TO "bcca-projects";
GRANT ALL ON SEQUENCE student_applications_id_seq TO "bcca-projects"