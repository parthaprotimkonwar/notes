package models.core;

import models.users.UserChapters;
import utilities.Constants;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "CHAPTERS", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class Chapters implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAPTER_ID")
    private Long chapterId;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "CHAPTER_NAME", nullable = false, length = 30)
    private String chapterName;

    @Column(name = "INDEXING", unique = true, nullable = false)
    private Integer indexing;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subjects subjectId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId")
    private Set<Modules> modules;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdChapterId.chapterId")
    private Set<UserChapters> userChapters;

}
