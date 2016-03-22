package com.github.gorbin.zarplataru;

import android.os.Parcel;
import android.os.Parcelable;

public class Vacancy implements Parcelable {

    private int id;
    private String add_date;
    private int owner_id;
    private String header;
    private Currency currency;
    private Education education;
    private ExpirienceLenght expirience_lenght;
    private WorkingType working_type;
    private Schedule schedule;
    private String description;
    private String url;
    private Company company;
    private String salary;

    public Vacancy() {

    }


    ////Generated stuff////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public ExpirienceLenght getExpirience_lenght() {
        return expirience_lenght;
    }

    public void setExpirience_lenght(ExpirienceLenght expirience_lenght) {
        this.expirience_lenght = expirience_lenght;
    }

    public WorkingType getWorking_type() {
        return working_type;
    }

    public void setWorking_type(WorkingType working_type) {
        this.working_type = working_type;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    protected Vacancy(Parcel in) {
        id = in.readInt();
        add_date = in.readString();
        owner_id = in.readInt();
        header = in.readString();
        currency = (Currency) in.readValue(Currency.class.getClassLoader());
        education = (Education) in.readValue(Education.class.getClassLoader());
        expirience_lenght = (ExpirienceLenght) in.readValue(ExpirienceLenght.class.getClassLoader());
        working_type = (WorkingType) in.readValue(WorkingType.class.getClassLoader());
        schedule = (Schedule) in.readValue(Schedule.class.getClassLoader());
        description = in.readString();
        url = in.readString();
        company = (Company) in.readValue(Company.class.getClassLoader());
        salary = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(add_date);
        dest.writeInt(owner_id);
        dest.writeString(header);
        dest.writeValue(currency);
        dest.writeValue(education);
        dest.writeValue(expirience_lenght);
        dest.writeValue(working_type);
        dest.writeValue(schedule);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeValue(company);
        dest.writeString(salary);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Vacancy> CREATOR = new Parcelable.Creator<Vacancy>() {
        @Override
        public Vacancy createFromParcel(Parcel in) {
            return new Vacancy(in);
        }

        @Override
        public Vacancy[] newArray(int size) {
            return new Vacancy[size];
        }
    };
}

class Currency implements Parcelable {
    private String title;

    public Currency() {
    }


    protected Currency(Parcel in) {
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Currency> CREATOR = new Parcelable.Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class Education implements Parcelable {
    private String title;

    public Education() {
    }


    protected Education(Parcel in) {
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Education> CREATOR = new Parcelable.Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class ExpirienceLenght implements Parcelable {
    private String title;

    public ExpirienceLenght() {
    }


    protected ExpirienceLenght(Parcel in) {
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ExpirienceLenght> CREATOR = new Parcelable.Creator<ExpirienceLenght>() {
        @Override
        public ExpirienceLenght createFromParcel(Parcel in) {
            return new ExpirienceLenght(in);
        }

        @Override
        public ExpirienceLenght[] newArray(int size) {
            return new ExpirienceLenght[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class WorkingType implements Parcelable {
    private String title;

    public WorkingType() {
    }


    protected WorkingType(Parcel in) {
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WorkingType> CREATOR = new Parcelable.Creator<WorkingType>() {
        @Override
        public WorkingType createFromParcel(Parcel in) {
            return new WorkingType(in);
        }

        @Override
        public WorkingType[] newArray(int size) {
            return new WorkingType[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class Schedule implements Parcelable {
    private String title;

    public Schedule() {
    }


    protected Schedule(Parcel in) {
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Schedule> CREATOR = new Parcelable.Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel in) {
            return new Schedule(in);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}