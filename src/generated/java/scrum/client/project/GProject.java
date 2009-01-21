









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtEntityGenerator










package scrum.client.project;

import java.util.*;

public abstract class GProject
            extends scrum.client.common.AGwtEntity {

    public GProject() {
    }

    public GProject(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "project";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- teamMembers ---

    private Set<String> teamMembersIds = new HashSet<String>();

    public final java.util.Set<scrum.client.admin.User> getTeamMembers() {
        if ( teamMembersIds.isEmpty()) return Collections.emptySet();
        return getDao().getUsers(this.teamMembersIds);
    }

    public final void addTeamMember(scrum.client.admin.User teamMember) {
        String id = teamMember.getId();
        if (teamMembersIds.contains(id)) return;
        teamMembersIds.add(id);
        propertyChanged("teamMembers", this.teamMembersIds);
    }

    public final void removeTeamMember(scrum.client.admin.User teamMember) {
        String id = teamMember.getId();
        if (!teamMembersIds.contains(id)) return;
        teamMembersIds.remove(id);
        propertyChanged("teamMembers", this.teamMembersIds);
    }

    // --- productOwner ---

    private String productOwnerId;

    public final scrum.client.admin.User getProductOwner() {
        return getDao().getUser(this.productOwnerId);
    }

    public final Project setProductOwner(scrum.client.admin.User productOwner) {
        String id = productOwner == null ? null : productOwner.getId();
        if (equals(this.productOwnerId, id)) return (Project) this;
        this.productOwnerId = id;
        propertyChanged("productOwner", this.productOwnerId);
        return (Project)this;
    }

    public final boolean isProductOwner(scrum.client.admin.User productOwner) {
        return equals(this.productOwnerId, productOwner);
    }

    // --- admins ---

    private Set<String> adminsIds = new HashSet<String>();

    public final java.util.Set<scrum.client.admin.User> getAdmins() {
        if ( adminsIds.isEmpty()) return Collections.emptySet();
        return getDao().getUsers(this.adminsIds);
    }

    public final void addAdmin(scrum.client.admin.User admin) {
        String id = admin.getId();
        if (adminsIds.contains(id)) return;
        adminsIds.add(id);
        propertyChanged("admins", this.adminsIds);
    }

    public final void removeAdmin(scrum.client.admin.User admin) {
        String id = admin.getId();
        if (!adminsIds.contains(id)) return;
        adminsIds.remove(id);
        propertyChanged("admins", this.adminsIds);
    }

    // --- description ---

    private java.lang.String description ;

    public final java.lang.String getDescription() {
        return this.description ;
    }

    public final Project setDescription(java.lang.String description) {
        this.description = description ;
        propertyChanged("description", this.description);
        return (Project)this;
    }

    public final boolean isDescription(java.lang.String description) {
        return equals(this.description, description);
    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Project setLabel(java.lang.String label) {
        this.label = label ;
        propertyChanged("label", this.label);
        return (Project)this;
    }

    public final boolean isLabel(java.lang.String label) {
        return equals(this.label, label);
    }

    // --- scrumMaster ---

    private String scrumMasterId;

    public final scrum.client.admin.User getScrumMaster() {
        return getDao().getUser(this.scrumMasterId);
    }

    public final Project setScrumMaster(scrum.client.admin.User scrumMaster) {
        String id = scrumMaster == null ? null : scrumMaster.getId();
        if (equals(this.scrumMasterId, id)) return (Project) this;
        this.scrumMasterId = id;
        propertyChanged("scrumMaster", this.scrumMasterId);
        return (Project)this;
    }

    public final boolean isScrumMaster(scrum.client.admin.User scrumMaster) {
        return equals(this.scrumMasterId, scrumMaster);
    }

    // --- currentSprint ---

    private String currentSprintId;

    public final scrum.client.sprint.Sprint getCurrentSprint() {
        return getDao().getSprint(this.currentSprintId);
    }

    public final Project setCurrentSprint(scrum.client.sprint.Sprint currentSprint) {
        String id = currentSprint == null ? null : currentSprint.getId();
        if (equals(this.currentSprintId, id)) return (Project) this;
        this.currentSprintId = id;
        propertyChanged("currentSprint", this.currentSprintId);
        return (Project)this;
    }

    public final boolean isCurrentSprint(scrum.client.sprint.Sprint currentSprint) {
        return equals(this.currentSprintId, currentSprint);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        teamMembersIds = (Set<String>) props.get("teamMembersIds");
        productOwnerId = (String) props.get("productOwnerId");
        adminsIds = (Set<String>) props.get("adminsIds");
        description  = (java.lang.String) props.get("description");
        label  = (java.lang.String) props.get("label");
        scrumMasterId = (String) props.get("scrumMasterId");
        currentSprintId = (String) props.get("currentSprintId");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("teamMembers", this.teamMembersIds);
        properties.put("productOwnerId", this.productOwnerId);
        properties.put("admins", this.adminsIds);
        properties.put("description", this.description);
        properties.put("label", this.label);
        properties.put("scrumMasterId", this.scrumMasterId);
        properties.put("currentSprintId", this.currentSprintId);
    }

}
