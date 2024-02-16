package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String director;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @ManyToOne
    @JoinColumn(name = "appuser_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "movie")
    private List<Rating> ratings;

    @Column(name = "is_accepted")
    private boolean isAccepted = false;

    @Column(name = "image_url")
    private String imageUrl;

}
