class Badge {
    public String print(Integer id, String name, String department) {
        String auxDepartment = (department == null) ? "OWNER" : department.toUpperCase();
        return (id != null) ? String.format("[%d] - %s - %s", id, name, auxDepartment)
                : String.format("%s - %s", name, auxDepartment.toUpperCase());
    }
}
