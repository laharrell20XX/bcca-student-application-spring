CREATE TABLE IF NOT EXISTS student_applications (
    id serial,
    name text,
    age int,
    phone_number text,
    email text,
    high_school text,
    graduation_date date,
    current_plan text,
    prior_knowledge text,
    eligibility boolean,
    aptitude text,
    dedication text,
    passion text
);

GRANT ALL PRIVILEGES ON student_applications TO "bcca-projects";
GRANT ALL ON SEQUENCE student_applications_id_seq TO "bcca-projects"